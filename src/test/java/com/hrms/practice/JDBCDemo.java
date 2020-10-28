package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test; //we will see this way the printing as ot was successufully connected
//if i use TestNg annotatations then it will show if it fails or passes

public class JDBCDemo {

	/** Storing username, password and URL into string variables */
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:mysql://hostname:port/db name
	// connection:driver type:hostname:port number/db name
	//Json database connectivity
	String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";

	@Test
	public void newConnection() throws SQLException { // add the exception
		
		/** Creating the connection by passing the parameters*/
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); // import java.sql.Connection;
																						
		System.out.println("DB Connection Succeseful"); // to make sure we actually connected to DB
		
		/** create Statement object*/
		Statement st = conn.createStatement(); // import java sql
		
		/** execute Query and store results from database in ResultSet object*/
		ResultSet rs = st.executeQuery("select * from hs_hr_employees"); // import java sql 
		
		// get values from resultset
		rs.next(); // moved one step forward, the iterator next
		String firstname = rs.getString("emp_firstname"); // or other different column name
		System.out.println(firstname);
		
		// another method -- better - because not all data is String, can be integer
		rs.next();
		String firstname2 = rs.getObject("emp_firstname").toString(); // even if integer we will convert to string											
		System.out.println(firstname2);
		
		// get the whole column
		while (rs.next()) {
			String allData = rs.getObject("emp_firstname").toString();
			System.out.println(allData);
		}
		// close all db connections
		rs.close();
		st.close();
		conn.close();
	}

	@Test
	public void listTask() throws SQLException { 
		/** create connection */
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); 																
		System.out.println("DB Connection Succeseful"); // to make sure we actually connected to DB

		/** Create statement */
		Statement st = conn.createStatement(); // interface
		
		/** create resultset object*/
		ResultSet rs = st.executeQuery("select * from ohrm_nationality"); // interface
		
		/** Create an arraylist of strings and add the objects converted to string */
		List<String> nationalities = new ArrayList<>();

		while (rs.next()) {
			String nationality = rs.getObject("name").toString();
			nationalities.add(nationality);
		}
		// retrieve and print the strings from the arraylist
		for (String nat : nationalities) {
			System.out.println(nat);
		}

        /** close all db connections*/
		rs.close();
		st.close();
		conn.close();// if we didnt close there can be a leakage of info and it will take in memory,
						// hackers can get also info

	}

	// if the db is down and not working will it affect our connection-- it will
	// affect have to report

}
