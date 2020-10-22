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

public class AdvancedDataStoring {

	static String dbUsername = "syntax_hrm";
	static String dbPassword = "syntaxhrm123";
	static String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";

	
	@Test
	public void advancedStuff() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id, name, country_code from ohrm_location");
		
	//	get all columnName and their resultset into list of maps as objects converted to strings
		List<Map<String, String>> listData = new ArrayList<>();
		Map<String, String> mapData;
		
		//exemple when we have few columns
		while(rs.next()) {
			mapData =  new LinkedHashMap<>(); // we need to initialize inside the while loop in order not to override with the last map
			mapData.put("id", rs.getObject("id").toString());       //key and value   
			mapData.put("name",rs.getObject("name").toString());
			mapData.put("country_code",rs.getObject("country_code").toString());
			listData.add(mapData);
		}
		System.out.println(listData);
		
		rs.close();
		st.close();
		conn.close();
	}
	
	@Test
	public void anotherTest() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		List<Map<String, String>> listData = new ArrayList<>();
		Map<String, String> mapData;
		
		////exemple when we have many columns, and keep it dynamic
		while(rs.next()) {  //runs through rows
			mapData =  new LinkedHashMap<>();  
			for(int i = 1; i <=rsMetaData.getColumnCount(); i++) {  //runs through columns  and keeps it dynamic
				String colName = rsMetaData.getColumnName(i); //key
				String value = rs.getObject(i).toString();    //value
				mapData.put(colName, value);
				listData.add(mapData);
			}
		}
		System.out.println(listData);
		rs.close();
		st.close();
		conn.close();
	}
	
	
		//display the info from nationality table
		//display id as nationality id, name as nationality name
	@Test
	public void task() throws SQLException {
	Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("select * from ohrm_nationality"); // (select id as 'Nationality ID', name as 'Nationality Name' from ohrm_nationality)
	ResultSetMetaData rsMetaData = rs.getMetaData();                  //won't work to change the column name as in the for loop we are getting the column name(getColumnName)
	List<Map<String, String>> listData = new ArrayList<>();
	Map<String, String> mapData;
	
	while (rs.next()) {
		mapData = new LinkedHashMap<>();
		for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {   //this way to keep it dynamic
			String colName = rsMetaData.getColumnName(i);
			if(colName.equals("id")) {               //have to put conditions in order to change the name of the column in the console
				colName = "Nationality ID";
			}else if(colName.equals("name")) {
				colName = "nationality Name";
			}
			String value = rs.getObject(i).toString();
			mapData.put(colName, value);
		}
		listData.add(mapData);
	}
	System.out.println(listData);
	rs.close();
	st.close();
	conn.close();
	}
}
