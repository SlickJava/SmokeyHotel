package com.smokeyhotel.management.command.commands;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.database.Database;

public class Help extends Command{

	public Help(Database database) {
		super("Help", "help", new String[] {}, database);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onExecute() {
		// TODO Auto-generated method stub
		System.out.println("");
	}

}
