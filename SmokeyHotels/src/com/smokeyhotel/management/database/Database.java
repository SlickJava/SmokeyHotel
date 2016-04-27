package com.smokeyhotel.management.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.awesome.db.AwesomeDatabase;
import com.awesome.db.ListResultMapper;
import com.awesome.db.ResultMapper;
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
	private AwesomeDatabase awesomeDatabase;
	private ListResultMapper<Guest> guestMapper;
	private ListResultMapper<Room> roomMapper;
	/**
	 * Initiate a data source and
	 * make a new AwesomeDatabase to use
	 */
	public Database() {
		 guestMapper = new ListResultMapper<Guest>() {
			public Guest mapRow(ResultSet resultSet) throws SQLException {
				return new Guest(resultSet.getDate("dob").toLocalDate(),
						resultSet.getString("name"),
						resultSet.getString("address"),
						resultSet.getString("phone"),
						resultSet.getString("creditCardNumber"),
						resultSet.getDate("expiryDate").toLocalDate(),
						resultSet.getString("creditCardName"),
						resultSet.getInt("creditCardSecurity"),
						resultSet.getLong("guestId"));
			}
		};
		roomMapper = new ListResultMapper<Room>() {
			public Room mapRow(ResultSet resultSet) throws SQLException {
//				return new Room(resultSet.getInt("number"),
//						resultSet.getBoolean("vacant"),
//						resultSet.getDouble("price"),
//						);
				return null;
			}
		};
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
	 * Returns awesomeDatabase
	 */
	public AwesomeDatabase getAwesomeDatabase() {
		return this.awesomeDatabase;
	}
	/*
	 * DO NOT USE YET!!! (unless you want to ruin the database
	 * and your own life.)
	 * 
	 * CREATE (insert)
	 * */
	/**
	 * Add a reservation
	 * @param reservation
	 */
	public void insertReservation(Reservation reservation) {
		// Maybe do: if exists (insert into guest values( ... ))
		// RESERVATION table.
		awesomeDatabase.createQuery("insert into reservation"
				+ "(reservation_code, master_guest_id) values "
				+ "(?,"
				+ "select id from guest where name=?)")
			.params(reservation.getCode(), reservation.getMaster().getName())
			.executeUpdate();
		// occupancyId, guestId, reservationId
		awesomeDatabase.createQuery("insert into guest_occupancy"
				+ "(occupancyId, guestId, reservationId) values("
				+ "(select occupancy.id from room join occupancy"
				+ "on (room.occupancyId = occupancy.id) where room.number=?),"
				+ "(select id from guest where id=?),"
				+ "(select id from reservation where reservationCode=?))")
			.setStatement(statement -> {
				for (Room room: reservation.getRooms()) {
					for (Guest guest: room.getOccupants()) {
						statement.setInt(1, room.getNumber());
						statement.setLong(2, reservation.getCode());
						statement.setLong(3, guest.getID());
						statement.addBatch();
					}
				}
			}).executeBatch();
		// Occupy rooms
		awesomeDatabase.createQuery("alter table room set isOccupied=1 where room.number=?")
			.setStatement(statement -> {
				for (int roomNumber: reservation.getRoomNumbers()) {
					statement.setInt(1, roomNumber);
					statement.addBatch();
				}
			}).executeBatch();
	}
	/**
	 * Add a guest
	 * @param guest
	 */
	public void insertGuest(Guest guest) {
		// Works
		awesomeDatabase.createQuery("insert into guest"
				+ " (dob, name, address, phone, creditCardNumber,"
				+ " expiryDate, creditCardName, creditCardSecurity, guestId)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)")
			// could've use params(), but imo this looks better
			// Lambdas FOR THE WIN
		    .setStatement(statement -> {
		    	statement.setDate(1, Date.valueOf(guest.getDob()));
		    	statement.setString(2, guest.getName());
		    	statement.setString(3, guest.getAddress());
		    	statement.setString(4, String.valueOf(guest.getPhone()));
		    	statement.setString(5, String.valueOf(guest.getPhone()));
		    	statement.setDate(6, Date.valueOf(guest.getExpiryDate()));
		    	statement.setString(7, guest.getCreditCardName());
		    	statement.setInt(8, guest.getCreditCardSecurity());
		    	statement.setLong(9, guest.getID());
		    	// contunie!!!!typo :)
		    }).executeUpdate();
	}
	/**
	 * Add a room
	 * @param room
	 */
	public void insertRoom(Room room) {
		// TODO
		awesomeDatabase.createQuery("insert into room (number, roomTypeId,"
				+ "currentReservationId, isOccupied) values (?, ?, ?, ?)")
			.params(room.getNumber()).executeUpdate();
	}
	/* READ (get)*/
	public ArrayList<Guest> getAllGuests() {
		// Get ArrayList from the List
		ArrayList<Guest> guests = new ArrayList<>(awesomeDatabase.createQuery("select * from guest")
				.executeQuery(guestMapper));
		return guests;
	}
	public ArrayList<Room> getAllRooms() {
		return new ArrayList<>(awesomeDatabase.createQuery("select * from rooms")
			.executeQuery(roomMapper));
	}
	public Reservation getAllReservations() {
		// TODO
		// IMPORTANT
		awesomeDatabase.createQuery("select * from reservation"
				+ "join room on (room.current_reservation_id = reservation.id)"
				+ "join guest on ()");
//			.executeQuery(new ResultMapper<Reservation>() {
//				
//			});
		return null;
	}
	public void deleteReservation(Reservation reservation) {
		
		// TOOOODO TODO
		// Del reservation, and del these guests.
		awesomeDatabase.createQuery("delete from reservation where reservationCode=?")
			.params(reservation.getCode()).executeUpdate();
		// Del links from guest_occupancy
		awesomeDatabase.createQuery("delete from guest_occupancy where guestUniqueId=?")
			.setStatement(statement -> {
				for (Guest guest: reservation.getOccupants()) {
					statement.setLong(1, guest.getID());
					statement.addBatch();
				}
			}).executeBatch();
		awesomeDatabase.createQuery("alter table room set isOccupied=0 where room.number=?")
			.setStatement(statement -> {
				for (int roomNumber: reservation.getRoomNumbers()) {
					statement.setInt(1, roomNumber);
					statement.addBatch();
				}
			}).executeBatch();
		
	}
	//public void 
}
