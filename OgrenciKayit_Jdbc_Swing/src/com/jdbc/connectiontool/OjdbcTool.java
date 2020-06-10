package com.jdbc.connectiontool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jdbc.interfaces.CoreInterfaces;



public class OjdbcTool extends CoreField implements CoreInterfaces {

	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

}
