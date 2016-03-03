package com.gavin.test.drools.two;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Fire {
	private Room room;

	public Fire(Room room) {
		super();
		this.room = room;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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
