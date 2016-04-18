package com.smokeyhotel.management.reservation;

import com.smokeyhotel.people.Person;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class Reservation {
	
	private Guest master;
	private Room rooms[];
	
	public Reservation(Guest master, Room rooms[])
	{
		this.master = master;
		this.rooms = rooms;
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
		int guests = 0;
		for(int i = 0; i < rooms.length; i++)
		{
			for(int j = 0; j < rooms[i].getOccupants().length; j++)
			{
				
				guests++;
			}
		}
		Guest[] fatMen = new Guest[guests];
		int index = 0;
		for(int i = 0; i < rooms.length; i++)
		{
			for(int j = 0; j < rooms[i].getOccupants().length; j++)
			{
				index++;
				fatMen[index] = 
			}
		}
		return fatMen;
		
	}
	
	public Guest getMaster() {
		return master;
	}
	

	public void setMaster(Guest master) {
		this.master = master;
	}

}
