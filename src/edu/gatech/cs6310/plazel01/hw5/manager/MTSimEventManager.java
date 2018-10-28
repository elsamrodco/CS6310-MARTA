package edu.gatech.cs6310.plazel01.hw5.manager;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

import edu.gatech.cs6310.plazel01.hw5.entitites.Bus;
import edu.gatech.cs6310.plazel01.hw5.entitites.Depot;
import edu.gatech.cs6310.plazel01.hw5.entitites.Route;
import edu.gatech.cs6310.plazel01.hw5.entitites.Stop;
import edu.gatech.cs6310.plazel01.hw5.simulation.SimEvent;
import edu.gatech.cs6310.plazel01.hw5.simulation.SimEventMoveBus;
import edu.gatech.cs6310.plazel01.hw5.utils.SimEventType;

public class MTSimEventManager {

	class SimEventComparator implements Comparator<SimEvent> {

		@Override
		public int compare(SimEvent lowerTimeEvent, SimEvent higherTimeEvent) {
			if (lowerTimeEvent.getLogicalStartTime() > higherTimeEvent.getLogicalStartTime()) {
				return 1;
			} else if (lowerTimeEvent.getLogicalStartTime() < higherTimeEvent.getLogicalStartTime()) {
				return -1;
			}
			return 0;
		}

	}

	private Map<Integer, Route> routes;
	private Map<Integer, Bus> buses;
	private Map<Integer, Depot> depots;

	private PriorityQueue<SimEvent> simEvents;

	private Map<Integer, Stop> stops;

	public MTSimEventManager() {
		depots = new HashMap<>();
		routes = new HashMap<>();
		buses = new HashMap<>();
		stops = new HashMap<>();
		simEvents = new PriorityQueue<SimEvent>(20, new SimEventComparator());
	}

	public void addBus(Integer busId, Integer routeId, int location, int initialRiders, int riderCapacity,
			int initialFuel, int fuelCapacity, int speed) {
		buses.put(busId,
				new Bus(busId, routeId, location, initialRiders, riderCapacity, initialFuel, fuelCapacity, speed));
	}

	public void addDepot(Integer depotId, String depotName, double xCoordinate, double yCoordinate) {
		depots.put(depotId, new Depot(depotId, depotName, xCoordinate, yCoordinate));
	}

	public void addEvent(int eventTime, String eventType, Integer eventId) {
		SimEventType eventTypeEnum = SimEventType.fromString(eventType);
		switch (eventTypeEnum) {
		case MOVE_BUS:
			SimEventMoveBus moveBusEvent = new SimEventMoveBus(eventId, eventTime, eventTypeEnum, buses.get(eventId));
			queueEvent(moveBusEvent);
			break;
		default:
			break;
		}
	}

	public void addRoute(Integer routeId, int routeNumber, String routeName) {
		routes.put(routeId, new Route(routeId, routeName, routeNumber));
	}

	public void addStop(Integer stopId, String stopName, int riders, double latitude, double longitude) {
		Stop newStop = new Stop(stopId, stopName, riders, latitude, longitude);
		stops.put(stopId, newStop);
	}

	private int calculateTravelTime(Double distance, int busSpeed) {
		return 1 + (distance.intValue() * 60 / busSpeed);
	}

	public void executeSimulation(int iterations) {
		/**
		 * Step 1: Read the data from the provided scenario configuration file (reused
		 * the reader provided) loop for twenty (20) iterations:
		 */
		while ((iterations--) > 0) {
			moveNextBus();
		}
	}

	public boolean extendRoute(Integer routeId, Integer stopId) {
		Route routeToBeExtended = routes.get(routeId);
		Stop stopToBeAdded = stops.get(stopId);
		return routeToBeExtended.extendRoute(stopToBeAdded);
	}

	public void moveNextBus() {
		/**
		 * Step 2. Determine which bus should be selected for processing (based on
		 * lowest arrival time). simEvents is a priority queue that uses a comparator to
		 * sort events based on not only the order of the queue, but also the lowest
		 * logical time
		 *
		 */
		SimEvent sm = simEvents.poll();
		if (Objects.nonNull(sm) && sm instanceof SimEventMoveBus) {
			/**
			 * Step 3 : Determine which stop the bus will travel to next (based on the
			 * current location and route)
			 */
			SimEventMoveBus simBusEvent = (SimEventMoveBus) sm;
			Bus movedBus = (Bus) simBusEvent.getReferencedSimObject();
			Route busRoute = routes.get(movedBus.getRouteId());
			int currentStop = movedBus.getLocation();
			Stop nextStop = busRoute.getNextStop(currentStop);

			/**
			 * Step 4 : Calculate the distance and travel time between the current and next
			 * stops
			 */
			Double distaceBetweenStops = busRoute.calculateDistanceBetweenStops(currentStop, nextStop);
			int travelTime = calculateTravelTime(distaceBetweenStops, movedBus.getSpeed());
			int currentEventLogicalTime = simBusEvent.getLogicalStartTime();
			/**
			 * Step 5: Display the output line of text to the display
			 */
			String moveBusOutput = String.format("b:%s->s:%d@%d//p:0/f:0", movedBus.getId(), nextStop.getId(),
					currentEventLogicalTime + travelTime);
			System.out.println(moveBusOutput);
			/**
			 * Step 6 : Update system state and generate new events as needed
			 */
			movedBus.setCurrentStop(currentStop, busRoute);
			SimEventMoveBus newEvent = new SimEventMoveBus(movedBus.getId(), currentEventLogicalTime + travelTime,
					SimEventType.MOVE_BUS, movedBus);
			queueEvent(newEvent);
		}
	}

	private void queueEvent(SimEvent simEvent) {
		simEvents.add(simEvent);
	}

}
