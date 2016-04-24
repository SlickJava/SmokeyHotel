package com.smokeyhotel.room.roomtypes;

import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class Room_SingleBed extends Room{

	public Room_SingleBed(int roomNumber, 
			boolean vacant,  double price,
			Guest[] occupants) {
		super(roomNumber, 1, vacant,  price, occupants);
		// TODO Auto-generated constructor stub
	}

}
