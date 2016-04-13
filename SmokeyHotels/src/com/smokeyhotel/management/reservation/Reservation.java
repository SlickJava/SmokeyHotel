package com.smokeyhotel.management.reservation;

import com.smokeyhotel.people.Person;

public class Reservation {
	
	private Person master;
	private int rooms;
	private int[] roomNumber;
	
	public Reservation(Person master, int rooms, int roomNumber[])
	{
		this.master = master;
		this.rooms = rooms;
		this.roomNumber = roomNumber;
	}

	public int getRoomNumber(int index)
	{
		return roomNumber[index];
	}
	
	public void setRoomNumber(int index, int value)
	{
		this.roomNumber[index] = value;
	}
	
	public Person getMaster() {
		return master;
	}

	public void setMaster(Person master) {
		this.master = master;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
}
