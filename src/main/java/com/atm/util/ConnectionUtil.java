package com.atm.util;

import java.sql.*;

import com.atm.encryptpassword.EncryptPassword;

public class ConnectionUtil {

	private ConnectionUtil() {

	}

	public static Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String userName = "system";
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", userName,
					EncryptPassword.decrypt());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			throw new RuntimeException("unable to load the Database Driver");
		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("unable to connect the Database");
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException("unable to connect the Database");
		}
	}

}
