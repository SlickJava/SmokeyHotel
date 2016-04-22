package com.smokeyhotel.management.command.commands;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.reservation.Reservation;
import com.smokeyhotel.management.reservation.ReservationManager;

public class DeleteReservation extends Command{

	public DeleteReservation() {
		super("Delete Reservation", "deletereservation", new String[] {"reservation"}, "Deletes a reservation");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onExecute() {
		
		Reservation res = this.getReservationFromString(this.inputs[0]);
		
		if(res != null)
		{
			if(ReservationManager.deleteReservation(res))
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
			System.out.println(ReservationManager.reservations.size());
			if(res.getCode() == Long.parseLong(mes))
			{
				System.out.println(res.getOccupants().length + " get occupants length full reservation");
				reservation = res;
			}
		}
		
		return reservation;
	}

}
