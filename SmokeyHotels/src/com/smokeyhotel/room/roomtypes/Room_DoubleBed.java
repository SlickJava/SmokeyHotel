package com.smokeyhotel.room.roomtypes;

import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;
import com.smokeyhotel.room.RoomState;

public class Room_DoubleBed extends Room{

	public Room_DoubleBed(int number, boolean vacant, RoomState roomState,
			double price, Guest[] occupants, long ID) {
		super(number, 2, vacant, roomState, price, occupants, ID);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
