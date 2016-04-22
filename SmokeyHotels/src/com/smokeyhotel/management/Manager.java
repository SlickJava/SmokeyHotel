package com.smokeyhotel.management;

import java.util.ArrayList;
import java.util.Scanner;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.command.commands.AddGuest;
import com.smokeyhotel.management.command.commands.AddReservation;
import com.smokeyhotel.management.command.commands.DeleteReservation;
import com.smokeyhotel.management.command.commands.Help;
import com.smokeyhotel.management.database.Database;

public class Manager {
	
	public static ArrayList<Command> commands = new ArrayList<Command>();
	private Database database;
	private Scanner scanner;
	
	public Manager()
	{
		scanner = new Scanner(System.in);
		database = new Database();
		this.addCommands();
	}
	
	public void addCommands()
	{
		commands.add(new AddReservation(database));
		commands.add(new DeleteReservation(database));
		commands.add(new AddGuest());
		commands.add(new Help());
	}
	
	public String readMessage()
	{
		String message = scanner.nextLine();
		return message;
	}
	
	/**
	 * Initiates the command. Runs through all commands, finds the matching message, 
	 * splits the string to find the parameters, then executes the command accordingly.
	 * 
	 * @param message
	 **/
	public void initiateCommand(String message)
	{
		String[] split = message.split(" ");
		
		if(!commands.contains(getCommandbyMessage(split[0]))) {
				System.out.println("Unkown command: " + split[0]);
				return;
		}
		
		for(Command command : commands)
		{
			if(command.getMessage().equals(split[0]))
			{
				String[] inputs = new String[command.getParameters().length];
				for(int i = 0; i < command.getParameters().length; i++)
				{
					inputs[i] = split[i+1];
				}
				command.setInputs(inputs);
				command.onExecute();
			}
		}

	}
	
	/**
	 * Initiates command listener. Listeners from commands.
	 **/
	public void initiateCommandListener()
	{
	    while (true) {
	    	String input = this.readMessage();
	        this.initiateCommand(input);
	        if(input.equals("exit")){
	            break;
	        }
	    }
	}
	
    public Command getCommandbyMessage(final String message)
    {
        for (final Command command : commands)
        {
            if (command.getMessage() == message || command.getMessage().equalsIgnoreCase(message))
            {
                return command;
            }
        }

        return null;
    }
}
