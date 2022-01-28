package com.atm.util;

import java.sql.*;

public class ConnectionUtil {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String userName = "system";
		String password = "oracle";
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", userName, password);
		
	}
}
