package com.smokeyhotel.management.reservation;

import java.util.ArrayList;

import com.smokeyhotel.people.Person;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class Reservation {
	
	private Guest master;
	private Room rooms[];
	private long code;
	
	public Reservation(long code,Guest master, Room rooms[])
	{
		this.master = master;
		this.rooms = rooms;
		this.code = code;
	}

	public long getCode()
	{
		return this.code;
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
		ArrayList<Guest> guests = new ArrayList<>();
		for(int i = 0; i < rooms.length; i++)
		{
			Guest[] roomGuests = rooms[i].getOccupants();
			//TEST STATEMENT BELOWd
			if(roomGuests == null)
				return null;
			for(int j = 0; j < roomGuests.length; j++)
			{
				guests.add(roomGuests[j]);
			}
		}
		// Convert to array
		return (Guest[]) guests.toArray(new Guest[guests.size()]);
	}
	
	public Guest getMaster() {
		return master;
	}
	

	public void setMaster(Guest master) {
		this.master = master;
	}

}
