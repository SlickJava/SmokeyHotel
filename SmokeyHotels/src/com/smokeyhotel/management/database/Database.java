package com.smokeyhotel.management.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.awesome.db.AwesomeDatabase;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.smokeyhotel.management.reservation.Reservation;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class Database {
	AwesomeDatabase awesomeDatabase;
	public Database() {
		try {
			FileReader reader = new FileReader("config.properties");
			Properties props = new Properties();
			props.load(reader);
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser(props.getProperty("user"));
			dataSource.setPassword(props.getProperty("password"));
			dataSource.setURL(props.getProperty("url"));
			awesomeDatabase = new AwesomeDatabase(dataSource);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertReservation(Reservation reservation) {
		
	}
	public void insertGuest(Guest guest) {
		
	}
	public void insertRoom(Room room) {
		
	}
}
