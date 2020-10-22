package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Recap {
	
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";

	@Test
	public void recap() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_skill");
		DatabaseMetaData dbMetaData = conn.getMetaData();
		String dbName = dbMetaData.getDatabaseProductName();
		System.out.println(dbName);
		
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int colCount = rsMetaData.getColumnCount();
		System.out.println(colCount);
		// retrieve the column names and the number
		for(int i = 1; i<=colCount; i++) {
			String colName = rsMetaData.getColumnName(i);
			System.out.println("Column Name : "+i + " "+ colName);
		}
		//get all id data from columns and name data from columns, printed as Strings
		while(rs.next()) {
			String id = rs.getObject("id").toString();
			String name = rs.getObject("name").toString();
			System.out.println(id + " = "+ name);
		}
		rs.close();
		st.close();
		conn.close();
	}
	
	
	
	
}
