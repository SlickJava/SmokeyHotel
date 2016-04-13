package com.smokeyhotel.management.reservation;

import com.smokeyhotel.people.Person;
import com.smokeyhotel.room.Room;

public class Reservation {
	
	private Person master;
	private int rooms;
	private int[] roomNumbers;
	
	public Reservation(Person master, int rooms, int roomNumber[])
	{
		this.master = master;
		this.rooms = rooms;
		this.roomNumbers = roomNumber;
	}

	public int getRoomNumber(int index)
	{
		return roomNumbers[index];
	}
	
	public void setRoomNumber(int index, int value)
	{
		this.roomNumbers[index] = value;
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
	
	public boolean hasRoom(Room room)
	{

		if(this.rooms != 1)
		{
			for(int i = 0; i <this.rooms; i++)
			{
				if(this.roomNumbers[i] == room.getNumber())
				{
					return true;
				}
			}
		}else
		{
			if(this.roomNumbers[0] == room.getNumber())
			{
				return true;
			}
		}
		//really didn't need that if statement lol
		
		return false;
	}
}
