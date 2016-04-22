package com.smokeyhotel.management.command.commands;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.database.Database;
import com.smokeyhotel.management.reservation.Reservation;
import com.smokeyhotel.management.reservation.ReservationManager;

public class DeleteReservation extends Command{

	private Database database;
	
	public DeleteReservation(Database database) {
		super("Delete Reservation", "deletereservation", new String[] {"reservation"}, "Deletes a reservation.");
		this.database = database;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onExecute() {
		
		Reservation res = this.getReservationFromString(this.inputs[0]);
		
		if(res != null)
		{
			if(ReservationManager.deleteReservation(res, database))
			{
				System.out.println("Reservation " + res.getCode() + " succesfully removed");
			}else{
				System.out.println("Reservation " + res.getCode() + " is not valid.");
			}
		}else
		{
			System.out.println("Reservation " + this.inputs[0] + " is invalid.");
		}
		
	}
	
	public Reservation getReservationFromString(String mes)
	{
		Reservation reservation = null;
		
		for(Reservation res : ReservationManager.reservations)
		{
			if(res.getCode() == Long.parseLong(mes))
			{
				reservation = res;
			}
		}
		
		return reservation;
	}

}
