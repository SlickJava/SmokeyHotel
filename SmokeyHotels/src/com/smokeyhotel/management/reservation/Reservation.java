package com.smokeyhotel.management.reservation;

import com.smokeyhotel.people.Person;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class Reservation {
	
	private Guest master;
	private Guest[] occupants;
	private Room rooms[];
	
	public Reservation(Guest master, Guest occupants[], Room rooms[])
	{
		this.master = master;
		this.rooms = rooms;
		this.occupants = occupants;
	}

	public Room[] getRooms()
	{
		return this.rooms;
	}

	public int[] getRoomNumbers()
	{
		int[] rNumbers = new int[rooms.length];
		for(int i = 0; i <rooms.length; i++)
		{
			rNumbers[i] = rooms[i].getNumber();
		}
		return rNumbers;
	}
	
	public Guest[] getOccupants()
	{
		return this.occupants;
	}
	
	public String[] getOccupantNames()
	{
		String[] oNames = new String[occupants.length];
		for(int i = 0; i < occupants.length; i++)
		{
			oNames[i] = occupants[i].getName();
		}
		return oNames;
	}
	
	public Guest getMaster() {
		return master;
	}
	

	public void setMaster(Guest master) {
		this.master = master;
	}

}
