package com.smokeyhotel;

import com.smokeyhotel.management.Manager;
import com.smokeyhotel.management.reservation.ReservationManager;
import com.smokeyhotel.room.Room;
import com.smokeyhotel.room.RoomType;

/**
 * Main Hotel.java class. Initiation happens here.
 * @author SlickJava & InsaneAboutTNT
 */

public class Hotel {
	
	public static int amountOfRooms;
	public static String hotelName;
	/**
	 * Example of how a Registration is made.
	 */
	public static void main(String args[])
	{
		//Next few lines are for teseting
		RoomType luxury = new RoomType("Luxury", 2, 4000.00);
		ReservationManager.rooms.add(new Room(1,luxury,true));
		ReservationManager.rooms.add(new Room(2,luxury,true));
		ReservationManager.rooms.add(new Room(3,luxury,true));
		ReservationManager.rooms.add(new Room(4,luxury,true));
		ReservationManager.rooms.add(new Room(5,luxury,true));
		ReservationManager.rooms.add(new Room(6,luxury,true));

		

		

		
		Manager manager = new Manager();
		manager.initiateCommandListener();
		
	}

}
