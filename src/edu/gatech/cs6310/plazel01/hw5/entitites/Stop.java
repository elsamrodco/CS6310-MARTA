package edu.gatech.cs6310.plazel01.hw5.entitites;

public class Stop extends SimObject {
	private String stopName;
	private int riders;
	private double latitude;
	private double longitude;

	public Stop(Integer id, String stopName, int riders, double latitude, double longitude) {
		super(id);
		this.stopName = stopName;
		this.riders = riders;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public int getRiders() {
		return riders;
	}

	public void setRiders(int riders) {
		this.riders = riders;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
