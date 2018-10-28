package edu.gatech.cs6310.plazel01.hw5.entitites;

public class Depot extends SimObject {
	private int depotId;
	private String depotName;
	private double xCoordinate;
	private double yCoordinate;

	public Depot(Integer depotId, String depotName, double xCoordinate, double yCoordinate) {
		super(depotId);
		this.depotId = depotId;
		this.depotName = depotName;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public int getDepotId() {
		return depotId;
	}

	public void setDepotId(int depotId) {
		this.depotId = depotId;
	}

	public String getDepotName() {
		return depotName;
	}

	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

}
