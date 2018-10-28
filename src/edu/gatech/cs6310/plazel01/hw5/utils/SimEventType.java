package edu.gatech.cs6310.plazel01.hw5.utils;

public enum SimEventType {
	MOVE_BUS, UNDEFINED;
	public static SimEventType fromString(String value) {
		if (value.equals("move_bus")) {
			return MOVE_BUS;
		} else {
			return UNDEFINED;
		}
	}
}
