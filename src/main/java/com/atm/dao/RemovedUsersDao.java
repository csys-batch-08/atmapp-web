package com.atm.dao;


import java.sql.SQLException;
import java.util.List;

import com.atm.models.RemovedUsersModel;

public interface RemovedUsersDao {
//insert data in removed users table:
	public int insertRemovedUsers(RemovedUsersModel removedusersmodel) throws SQLException;

	// fetch users data:
	public List<RemovedUsersModel> fetchRemovedUsers() throws SQLException;

}
