package edu.gatech.cs6310.plazel01.hw5.entitites;

public class Bus extends SimObject {

	private Integer routeId;
	private int location;
	private int initialRiders;
	private int riderCapacity;
	private int initialFuel;
	private int fuelCapacity;
	private int speed;

	public Bus(Integer busId, Integer routeId, int location, int initialRiders, int riderCapacity, int initialFuel,
			int fuelCapacity, int speed) {
		super(busId);
		this.routeId = routeId;
		this.location = location;
		this.initialFuel = initialFuel;
		this.riderCapacity = riderCapacity;
		this.initialFuel = initialFuel;
		this.fuelCapacity = fuelCapacity;
		this.speed = speed;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public int getInitialFuel() {
		return initialFuel;
	}

	public int getInitialRiders() {
		return initialRiders;
	}

	public int getLocation() {
		return location;
	}

	public int getRiderCapacity() {
		return riderCapacity;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public int getSpeed() {
		return speed;
	}

	public void setCurrentStop(int currentStop, Route busRoute) {
		currentStop++;
		if (currentStop >= busRoute.getStops().size()) {
			// Reset location
			location = 0;
		} else {
			location = currentStop;
		}
	}

}
