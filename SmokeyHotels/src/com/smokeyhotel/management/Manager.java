package com.smokeyhotel.management;

import java.util.Scanner;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.command.CommandManager;
import com.smokeyhotel.management.database.Database;
import com.smokeyhotel.management.reservation.ReservationManager;

public class Manager {
	
	private ReservationManager reservationManager;
	private CommandManager commandManager;
	private Database database;
	private Scanner scanner;
	
	public Manager()
	{
		database = new Database();
		reservationManager = new ReservationManager();
		commandManager = new CommandManager(database);
	}
	
	public String readMessage()
	{
		String message = scanner.nextLine();
		return message;
	}
	
	public void initiateCommand(String message)
	{
		String[] split = message.split(" ");
		for(Command command : commandManager.commands)
		{
			if(command.getMessage() == split[0])
			{
				String[] inputs = new String[command.getParameters().length];
				for(int i = 1; i < command.getParameters().length; i++)
				{
					split[i] = inputs[i-1];
				}
				command.setInputs(inputs);
				command.onExecute();
			}
		}
	}
	
	
	
	
	
	
	
}
