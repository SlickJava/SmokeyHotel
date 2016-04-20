package com.smokeyhotel.management.command.commands;

import com.smokeyhotel.management.Manager;
import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.database.Database;

public class Help extends Command{

	public Help() {
		super("Help", "help", new String[] {}, "Display Help.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onExecute() {
		for(Command command : Manager.commands)
		{
			String[] params = command.getParameters();
			String convertedParam = "";
			for(int i = 0; i < params.length; i++)
			{
				String individualParam = params[i] + " ";
				convertedParam = convertedParam + individualParam;
			}
			if(params.length == 0)
				System.out.println(command.getMessage() +
						" - " + command.getDescription() + " | Params: No parameters found.");
			else
			System.out.println(command.getMessage() +
					" - " + command.getDescription() + " | Params: " + convertedParam);
		}
		System.out.println("");
	}

}
