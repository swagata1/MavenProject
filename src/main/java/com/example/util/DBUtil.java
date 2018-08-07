package com.example.util;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.exceptions.DBUtilityException;

/**
 * 
 * This class provides utility methods for establishing and releasing database
 * connection. It provides methods to release various resources used in database
 * connection.
 */
public class DBUtil {

	/**
	 * 
	 * @return database connection
	 * @throws DBUtilityException
	 *             This method is meant to establish database connection, and
	 *             returns the Connection object after successfully establishing
	 *             the connection.
	 */
	public static Connection getConnection() throws DBUtilityException {
		Connection connection = null;

		try {
			Class.forName(Config.DRIVER);
			connection = DriverManager.getConnection(Config.URL, Config.USER, Config.PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new DBUtilityException("Error in establishing connection", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DBUtilityException("Error in establishing connection", e);
		}

		return connection;
	}

	/**
	 * 
	 * @param con
	 * @throws DBUtilityException
	 *             This method is meant to release the instance of Connection
	 *             class.
	 */
	public static void releaseConnection(Connection connection) throws DBUtilityException {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new DBUtilityException("Error in closing connection", e);
		}
	}

}
