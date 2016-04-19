package com.smokeyhotel.management.command;

import java.util.ArrayList;

import com.smokeyhotel.management.command.commands.AddReservation;
import com.smokeyhotel.management.database.Database;

public class CommandManager {

	public static ArrayList<Command> commands = new ArrayList<Command>();
	
	public CommandManager(Database database)
	{
		commands.add(new AddReservation(database));
	}
	
	
	

	
}
