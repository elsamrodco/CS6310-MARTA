package edu.gatech.cs6310.plazel01.hw5.entitites;

import java.util.ArrayList;
import java.util.List;

public class Route extends SimObject {
	private String name;
	private int number;
	private List<Stop> stops;

	public Route(Integer id, String name, int number) {
		super(id);
		this.name = name;
		this.number = number;
		stops = new ArrayList<>();
	}

	public Double calculateDistanceBetweenStops(int initialStopIndex, Stop finalStop) {
		Stop initialStop = stops.get(initialStopIndex);
		Double xCoordinatesSubstration = Math.pow((initialStop.getLongitude() - finalStop.getLongitude()), 2);
		Double yCoordinateSubtraction = Math.pow((initialStop.getLatitude() - finalStop.getLatitude()), 2);
		return 70.0 * Math.sqrt(xCoordinatesSubstration + yCoordinateSubtraction);
	}

	public boolean extendRoute(Stop stopToBeAdded) {
		return stops.add(stopToBeAdded);
	}

	public String getName() {
		return name;
	}

	public Stop getNextStop(int currentStop) {
		currentStop++;
		if (currentStop >= stops.size()) {
			return stops.get(0);
		} else {
			return stops.get(currentStop);
		}
	}

	public int getNumber() {
		return number;
	}

	public List<Stop> getStops() {
		return stops;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
