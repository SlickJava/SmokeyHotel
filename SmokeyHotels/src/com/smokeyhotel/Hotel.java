package com.smokeyhotel;

import java.time.LocalDate;

import javax.sql.DataSource;

import com.awesome.db.Query;
import com.smokeyhotel.management.Manager;
import com.smokeyhotel.management.reservation.Reservation;
import com.smokeyhotel.management.reservation.ReservationManager;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;
import com.smokeyhotel.room.RoomState;

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
		ReservationManager.rooms.add(new Room(1,2,true,RoomState.MADE, 20,null,1));
		ReservationManager.rooms.add(new Room(2,1,true,RoomState.MADE, 20,null,2));
		ReservationManager.rooms.add(new Room(3,1,true,RoomState.MADE, 20,null,3));
		ReservationManager.rooms.add(new Room(4,1,true,RoomState.MADE, 20,null,4));
		ReservationManager.rooms.add(new Room(5,1,true,RoomState.MADE, 20,null,5));
		ReservationManager.rooms.add(new Room(6,1,true,RoomState.MADE, 20,null,6));
		ReservationManager.guests.add(new Guest(LocalDate.now(), "Bob", "somewhereovertherainbow", 0211231234L, 9999999999999999L, LocalDate.now(), "ChickenMan", 375, 1L));
		ReservationManager.guests.add(new Guest(LocalDate.now(), "Chode", "somewhereovertherainbow", 0211231234L, 9999999999999999L, LocalDate.now(), "ChickenMan", 375, 2L));
		ReservationManager.guests.add(new Guest(LocalDate.now(), "Fat", "somewhereovertherainbow", 0211231234L, 9999999999999999L, LocalDate.now(), "ChickenMan", 375, 3L));

		
		Manager manager = new Manager();
		manager.initiateCommandListener();
		
	}

}
