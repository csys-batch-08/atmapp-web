package com.atm.daoimpl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.atm.dao.RemovedUsersDao;
import com.atm.models.RemovedUsersModel;
import com.atm.util.ConnectionUtil;


public class RemovedUsersImpl implements RemovedUsersDao {
	// Insert data into removed users:
	public int insertRemovedUsers(RemovedUsersModel removedusersmodel) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "insert into removedusers(user_acc_no,username,last_balance,mob_no,user_pin) values(?,?,?,?,?)";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setLong(1, removedusersmodel.getUserAccountNo());
			statement.setString(2, removedusersmodel.getUserName());
			statement.setInt(3, removedusersmodel.getLastBalance());
			statement.setLong(4, removedusersmodel.getMobileNo());
			statement.setInt(5, removedusersmodel.getUserPin());
			res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
			}
		return res;
		
	}

//fetch user:

	public List<RemovedUsersModel> fetchRemovedUsers() throws SQLException {
		List<RemovedUsersModel> removedUsersModels = new ArrayList<>();
		Connection con = null;
		Statement statement = null;
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		try {
			con = ConnectionUtil.getConnection();
			String query = "select id,user_acc_no,username,last_balance,mob_no,user_pin,acc_removed_at from removedusers order by id desc";
			statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				removedUsersModels.add(new RemovedUsersModel(resultSet.getInt(1), resultSet.getLong(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getLong(5), resultSet.getInt(6), (resultSet.getTimestamp(7)).toLocalDateTime().format(dateTimeFormatter)));
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
			}
		return removedUsersModels;
	}
}
