package com.smokeyhotel;

import javax.sql.DataSource;

import com.awesome.db.Query;
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
	
	/**
	 * Example of how a Registration is made.
	 */
	public static void main(String args[])
	{
		/**
		 * Initiate Registration Manager.
		 */
		ReservationManager res = new ReservationManager();
		
		Guest master = new Guest(20, "Bob Jones", "120 Long Drive", "St Heliers", "0211824071", "1238120381203");
		Guest guest1 = new Guest(25, "Joel Alexander", "120 Long Drive", "St Heliers", "0211824071", "1238120381203");
		Guest guest2 = new Guest(20, "Veronica Bagley", "52 John Cena Street", "Germany", "982018371", "2315123381297");
		Guest guest3 = new Guest(20, "Owen Bao", "52 John Cena Street", "Germany", "982018371", "2315123381297");
		Guest guest4 = new Guest(20, "Catherine Chang", "52 John Cena Street", "Germany", "982018371", "2315123381297");
		Guest guest5 = new Guest(20, "Oliver Christie", "52 John Cena Street", "Germany", "982018371", "2315123381297");
		Guest guest6 = new Guest(20, "Alexis Hindley", "52 John Cena Street", "Germany", "982018371", "2315123381297");

		Guest[] occupants = new Guest[] {guest1,guest2,guest3,guest4,guest5,guest6};
		
		Room[] rooms = new Room[1];
		rooms[0] = new Room(569,false,RoomState.DAMAGED,500.00,occupants);
		
		res.createReservation(new Reservation(1,master,rooms));
		
		res.printGuests();
		
	}

}
