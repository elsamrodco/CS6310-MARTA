package edu.gatech.cs6310.plazel01.hw5.entitites;

public class Rider extends SimObject {
	public Rider(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private String fName;
	private String lName;
	private int departureTime;
	private int arrivalTime;
	private String currentBus;
	private boolean isRidingBus;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getCurrentBus() {
		return currentBus;
	}

	public void setCurrentBus(String currentBus) {
		this.currentBus = currentBus;
	}

	public boolean isRidingBus() {
		return isRidingBus;
	}

	public void setRidingBus(boolean isRidingBus) {
		this.isRidingBus = isRidingBus;
	}

}
