package edu.gatech.cs6310.plazel01.hw5.simulation;

import edu.gatech.cs6310.plazel01.hw5.entitites.Bus;
import edu.gatech.cs6310.plazel01.hw5.utils.SimEventType;

public class SimEventMoveBus extends SimEvent {

	public SimEventMoveBus(int eventId, int logicalStartTime, SimEventType eventType, Bus referencedSimObject) {
		super(eventId, logicalStartTime, eventType, referencedSimObject);
	}

}
