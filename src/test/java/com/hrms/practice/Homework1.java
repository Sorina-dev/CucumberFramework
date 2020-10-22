package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * get the resultset metadata store it in arraylist, retrieve from arraylist and print in console
   also get column type name and get table names
 */
public class Homework1 {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	
	@Test
	public void resultSetMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title;");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		List<String> jobTitles = new ArrayList<>();
		
		while(rs.next()) {
			String job = rs.getObject("job_title").toString();
			jobTitles.add(job);
		}
		
		for(String j:jobTitles) {
			System.out.println(j);
		}
		
		
		String columnTypeName = rsMetaData.getColumnTypeName(2);
		System.out.println("Column Type Name = " + columnTypeName);
		
		String tableName = rsMetaData.getTableName(1);
		System.out.println("Table name = "+ tableName);
		
	}
	
	
}
