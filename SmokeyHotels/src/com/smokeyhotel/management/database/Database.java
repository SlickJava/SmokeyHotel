package com.smokeyhotel.management.database;

import com.awesome.db.AwesomeDatabase;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {
	AwesomeDatabase awesomeDatabase;
	public Database() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("john");
		dataSource.setUser("123");
		dataSource.setURL("jdbc:mysql://122.60.10.170/hotel");
		awesomeDatabase = new AwesomeDatabase(dataSource);
	}
}
