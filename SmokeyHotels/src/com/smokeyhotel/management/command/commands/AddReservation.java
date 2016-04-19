package com.smokeyhotel.management.command.commands;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.database.Database;

public class AddReservation extends Command{

	public AddReservation(Database database) {
		super("AddReservation", "addreservation", new String[] {"master","guests"}, database);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onExecute() {
		// TODO Auto-generated method stub
		
	}
	
	public void allocateRooms() {
		
	}
	

	


}
