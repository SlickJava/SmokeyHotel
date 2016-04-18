package com.smokeyhotel.management;

import com.smokeyhotel.management.database.Database;
import com.smokeyhotel.management.reservation.ReservationManager;

public class Manager {
	
	private ReservationManager reservationManager;
	private Database database;
	
	public Manager()
	{
		database = new Database();
		reservationManager = new ReservationManager();
	}
	
	
}
