package com.atm.util;

import java.sql.*;

import com.atm.encryptpassword.EncryptPassword;
import com.atm.logger.Logger;

public class ConnectionUtil {

	private ConnectionUtil() {

	}

	public static Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String userName = "system";
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", userName,
					EncryptPassword.decrypt());
		} catch (ClassNotFoundException  | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} catch (Exception e1) {
			Logger.printStackTrace(e1);
			Logger.runTimeException(e1.getMessage());
		}
		return null;
	}

}
