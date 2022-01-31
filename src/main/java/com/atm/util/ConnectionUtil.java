package com.atm.util;

import java.sql.*;

import com.atm.encryptpassword.EncryptPassword;

public class ConnectionUtil {

	private ConnectionUtil() {
		
	}
	public static Connection getConnection() throws Exception {	
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String userName = "system";
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", userName, EncryptPassword.decrypt());	
	}
	
}
