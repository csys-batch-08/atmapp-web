package com.atm.util;

import java.sql.*;

public class ConnectionUtil {
	private ConnectionUtil() {
		
	}
	public static Connection getConnection() throws ClassNotFoundException,SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String userName = "system";
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", userName, "oracle");	
	}
	
}
