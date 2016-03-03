package com.gavin.test.drools.two;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Sprinkler {
	private Room room;
	private boolean on;

	public Sprinkler(Room room) {
		super();
		this.room = room;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
