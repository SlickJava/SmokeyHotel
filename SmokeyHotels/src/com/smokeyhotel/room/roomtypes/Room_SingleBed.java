package com.smokeyhotel.room.roomtypes;

import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class Room_SingleBed extends Room{

	public Room_SingleBed(int roomNumber, 
			boolean vacant,  double price,
			Guest[] occupants, long ID) {
		super(roomNumber, 1, vacant,  price, occupants, ID);
		// TODO Auto-generated constructor stub
	}

}
