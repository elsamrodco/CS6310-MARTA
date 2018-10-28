package edu.gatech.cs6310.plazel01.hw5.simulation;

import edu.gatech.cs6310.plazel01.hw5.entitites.SimObject;
import edu.gatech.cs6310.plazel01.hw5.utils.SimEventType;

public abstract class SimEvent {
	private int eventId;
	private int logicalStartTime;
	private SimEventType eventType;
	private SimObject referencedSimObject;

	public SimEvent(int eventId, int logicalStartTime, SimEventType eventType, SimObject referencedSimObject) {
		this.eventId = eventId;
		this.logicalStartTime = logicalStartTime;
		this.eventType = eventType;
		this.referencedSimObject = referencedSimObject;
	}

	public int getEventId() {
		return eventId;
	}

	public SimEventType getEventType() {
		return eventType;
	}

	public int getLogicalStartTime() {
		return logicalStartTime;
	}

	public SimObject getReferencedSimObject() {
		return referencedSimObject;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public void setEventType(SimEventType eventType) {
		this.eventType = eventType;
	}

	public void setLogicalStartTime(int logicalStartTime) {
		this.logicalStartTime = logicalStartTime;
	}

	public void setReferencedSimObject(SimObject referencedSimObject) {
		this.referencedSimObject = referencedSimObject;
	}

}
