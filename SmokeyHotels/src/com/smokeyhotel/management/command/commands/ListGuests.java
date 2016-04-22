package com.smokeyhotel.management.command.commands;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.reservation.ReservationManager;

public class ListGuests extends Command{

	public ListGuests() {
		super("ListGuests", "listguests", new String[] {}, "Lists Guests.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onExecute() {
		
		ReservationManager.printGuests();
		
	}
	
	

}
