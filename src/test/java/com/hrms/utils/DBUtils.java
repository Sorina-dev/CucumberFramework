package com.hrms.utils;

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

public class DBUtils {

	public static Connection conn;
	public static Statement st;
	public static ResultSet rs;
	public static List<Map<String, String>> listData;

	/**
	 * this method will get connected to the DB
	 */
	public static void getConnected() {
		try {
			conn = DriverManager.getConnection(ConfigsReader.getPropValue("dbUrl"),
					ConfigsReader.getPropValue("dbUsername"), ConfigsReader.getPropValue("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * this method will execute the query and store the data inside the list of maps
	 * @param sqlQuery
	 * @return <-- List<Map<String, String>>
	 */
	public static List<Map<String, String>> storeDataFromBD(String sqlQuery) {
		getConnected();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sqlQuery);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			listData = new ArrayList<>();   //its better to have it as an instance variable in order to get access from other classes too
			
			while(rs.next()) {
				Map<String, String> mapData = new LinkedHashMap<>();
				for(int i = 1; i<= rsMetaData.getColumnCount(); i++) {
					// key- column name                          value-data
					mapData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
				}
				listData.add(mapData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listData;
	}

	
	/**
	 * this method will close the whole DB connection
	 */
	public static void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
