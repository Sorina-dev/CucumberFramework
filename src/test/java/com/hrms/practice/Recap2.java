package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Recap2 {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";

	@Test
	public void recapDb() throws SQLException {

		/**
		 * calling the method getConnection from the DriverManager class and store the
		 * value into a variable of Connection interface of the sql
		 */
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);// object of the interface

		/**
		 * calling the createStatement method from Connection interface and store the
		 * value in st returns a statement object, Statement interface
		 */
		Statement st = conn.createStatement(); // object of the interface

		/**
		 * calling executeQuery method from the Statement interface and store the value
		 * in ResultSet interface and returns a resultset object
		 */
		ResultSet rs = st.executeQuery("select * from ohrm_nationality"); // object of the interface

		/**
		 * create the rsMetaData object from ResultSetMetaData interface by calling the
		 * method getMetaData() from ResultSet interface
		 */
		ResultSetMetaData rsMetaData = rs.getMetaData();

		/**
		 * creating a list of maps like using array list that is ordered and easier to
		 * retrieve and fetch the data, where will be stored the rsMetaData
		 */
		List<Map<String, String>> listData = new ArrayList<>();

		/** declaring the map stored into the array list */
		Map<String, String> mapData;

		/** using while loop to loop over the rows */
		while (rs.next()) {
			/**
			 * initialize the map declared before as LinkedHashMap as it keeps the
			 * insertion-order, it is initialized in the loop cuz when the row its
			 * completed, the data to be stored in a new map
			 */
			mapData = new LinkedHashMap<>();

			/**
			 * looping through columns, dont't need the table name(header), as a condition
			 * use the getColumnCount() from ResultSetMetaData interface
			 */
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {

				/**
				 * Store the keys and values in to the map. The key --> getColumnName() from
				 * ResultSetMetaData interface and the value --> getObject() converted to String
				 * from ResultSet interface
				 */
				mapData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			}
			
			/** After creating the map we store each map into listData Arraylist */
			listData.add(mapData);
		}
		
		/** print the stored list of maps and close the connection, statement and resultset objects*/
		System.out.println(listData);
		rs.close();
		st.close();
		conn.close();
	}
}
