package com.smokeyhotel.room.roomtypes;

import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;
import com.smokeyhotel.room.RoomState;

public class Room_SingleBed extends Room{

	public Room_SingleBed(int roomNumber, 
			boolean vacant, RoomState roomState, double price,
			Guest[] occupants, long ID) {
		super(roomNumber, 1, vacant, roomState, price, occupants, ID);
		// TODO Auto-generated constructor stub
	}

}
