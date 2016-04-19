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

/**
 * @author InsaneAboutTNT
 * This class houses the database
 * and provides methods for adding and
 * deleting data in the hotel database.
 */
public class Database {
	AwesomeDatabase awesomeDatabase;
	/**
	 * Initiate a data source and
	 * make a new AwesomeDatabase to use
	 */
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Add a reservation
	 * @param reservation
	 */
	public void insertReservation(Reservation reservation) {
		// TODO
		awesomeDatabase.createQuery("insert into app.reservation () values ()");
	}
	/**
	 * Add a guest
	 * @param guest
	 */
	public void insertGuest(Guest guest) {
		// TODO
		awesomeDatabase.createQuery("insert into app.guests () values ()");
	}
	/**
	 * Add a room
	 * @param room
	 */
	public void insertRoom(Room room) {
		// TODO
		awesomeDatabase.createQuery("insert into app.room () values ()");
	}
}
