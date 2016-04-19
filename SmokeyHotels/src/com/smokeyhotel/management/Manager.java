package com.smokeyhotel.management;

import java.util.ArrayList;
import java.util.Scanner;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.command.commands.AddReservation;
import com.smokeyhotel.management.database.Database;
import com.smokeyhotel.management.reservation.ReservationManager;

public class Manager {
	
	private ArrayList<Command> commands = new ArrayList<Command>();
	private ReservationManager reservationManager;
	private Database database;
	private Scanner scanner;
	
	public Manager()
	{
		scanner = new Scanner(System.in);
		database = new Database();
		reservationManager = new ReservationManager();
		this.addCommands();
	}
	
	public void addCommands()
	{
		commands.add(new AddReservation(database));
	}
	
	public String readMessage()
	{
		String message = scanner.nextLine();
		return message;
	}
	
	public void initiateCommand(String message)
	{
		System.out.println(message + "- Message");
		String[] split = message.split(" ");		
		for(Command command : commands)
		{
			if(command.getMessage().equals(split[0]))
			{
				System.out.println(split[0] + "-" + command.getCommandName());
				String[] inputs = new String[command.getParameters().length];
				for(int i = 0; i < command.getParameters().length; i++)
				{
					System.out.println("reached");
					inputs[i] = split[i+1];
				}
				command.setInputs(inputs);
				System.out.println(inputs[0] + "-" + command.getCommandName());
				command.onExecute();
				
			}
		}
	}
	
	
	
	
	
	
	
}
