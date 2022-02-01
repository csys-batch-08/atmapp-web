package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.atm.logger.Logger;
import com.atm.models.UsernamePasswordModel;
import com.atm.util.ConnectionUtil;

public class UsernamePasswordImpl implements com.atm.dao.UsernamePasswordDao {
	Scanner sc = new Scanner(System.in);
	String commitString = "commit";

	// Get Role:
	/**
	 * this method is used to fetch role for the given UserName Password:
	 */
	public String fetchRole(UsernamePasswordModel usernamepasspojo) throws SQLException {

		String role = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select role from usernamepassword where username = ? and password = ?";
			statement = con.prepareStatement(query);
			statement.setString(1, usernamepasspojo.getUserName());
			statement.setString(2, usernamepasspojo.getPassword());
			rs = statement.executeQuery();
			if (rs.next()) {
				role = rs.getString("role");
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return role;
	}

	// password change:
	/**
	 * this method is used to change the login password of users for given username
	 * and password:
	 */
	public int userPinChange(UsernamePasswordModel usernamepasspojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "update usernamepassword set password = ? where username in ?";
			String query1 = commitString;
			statement = con.prepareStatement(query);
			statement.setString(1, usernamepasspojo.getPassword());
			statement.setString(2, usernamepasspojo.getUserName());
			res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return res;
	}

	// insert User name password:
	/**
	 * this method is used to insert new username password UserDetails:
	 */
	public int insertUsernamePasswords(UsernamePasswordModel usernamepasspojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "insert into usernamepassword(username,password,role) values(?,?,?)";
			String query1 = commitString;
			statement = con.prepareStatement(query);
			statement.setString(1, usernamepasspojo.getUserName());
			statement.setString(2, usernamepasspojo.getPassword());
			statement.setString(3, usernamepasspojo.getRole());
			res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return res;
	}

	// remove account:
	/**
	 * this method is used to remove account for the given username:
	 */
	public int removeUser(UsernamePasswordModel usernamepasspojo) throws SQLException {
		Connection con = null;
		int res = -1;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "delete from usernamepassword where username in ?";
			String query1 = commitString;
			statement = con.prepareStatement(query);
			statement.setString(1, usernamepasspojo.getUserName());
			res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return res;
	}
}
