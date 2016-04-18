package com.smokeyhotel.management.reservation;

import java.util.ArrayList;

import com.smokeyhotel.people.Person;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class Reservation {
	
	private Guest master;
	private Room rooms[];
	private long id;
	
	public Reservation(long id,Guest master, Room rooms[])
	{
		this.master = master;
		this.rooms = rooms;
		this.id = id;
	}

	public long getId()
	{
		return this.id;
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
			for(int j = 0; j < rooms[i].getOccupants().length; j++)
			{
				guests.add(roomGuests[j]);
			}
		}
		// Convert to array
		return (Guest[]) guests.toArray();
	}
	
	public Guest getMaster() {
		return master;
	}
	

	public void setMaster(Guest master) {
		this.master = master;
	}

}
