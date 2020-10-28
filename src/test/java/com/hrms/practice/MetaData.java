package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaData {

	/** Store the username, password and url into string variables*/
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:mysql://hostname:port/db name
	String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	
	//@Test  //@Test -- to comment out the test
	public void dbMetaData() throws SQLException {
		
		/** create the connection */
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		/** get the metadata from the connection */
		//interface                   from connection call the method getMetaData();
		DatabaseMetaData dbMetaData = conn.getMetaData(); //import from java sql
		
		/** get the driver name from metadata*/
		//gives a string     from DatabaseMetaData interface call the build-in method getDriverName();
		String driverName = dbMetaData.getDriverName();
		
		/** get the product version of the database*/
		//return a string value     from DatabaseMetaData interface call the method getDatabaseProductVersion(); 
		String  version = dbMetaData.getDatabaseProductVersion(); 
		
		System.out.println(driverName);
		System.out.println(version);
		
		/** close the connection */
		conn.close();
	}
	//ResultSetMetaData get it from getMetaData() from ResultSet 
	//       VS
	// DatabaseMetaData get it from getMetaData() from Connection
	
	
	@Test   
	public void resultSetMetaData() throws SQLException {
		
		/** create the connection */
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		/** create the statement */
		Statement st = conn.createStatement();
		
		/** create the resultSet object*/
		ResultSet rs = st.executeQuery("select * from hs_hr_employees where employee_id = 8392");
		
		/** get the rsMetadata  from the resultSet */
		ResultSetMetaData rsMetadata = rs.getMetaData();  //interface import from java sql
		
		/** get the Column count from resultsetmetadata*/
		int columnCount = rsMetadata.getColumnCount(); 
		System.out.println(columnCount);
		
		/** get the column name from resultsetmetadata*/
		String firstColumnName =  rsMetadata.getColumnName(1); //this is not coming from java. it is coming from sql so it starts from 1
		System.out.println(firstColumnName);
		
		/**get all the column names using for loop*/
		for(int i = 1; i<= columnCount; i++) {  // cuz we start from 1, its <=
			String colNames = rsMetadata.getColumnName(i);
			System.out.println(colNames);
		}  
		
	}
}
