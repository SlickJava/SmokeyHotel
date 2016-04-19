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
		
		for(int i = 0; i < this.inputs.length; i++)
		{
			System.out.println(this.inputs[i]);
		}
	}
	
	public void allocateRooms() {

	}

}
