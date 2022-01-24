package com.atm.dao;

import java.sql.ResultSet;
import java.util.List;

import com.atm.models.RemovedUsersModel;

public interface RemovedUsersDao {
//insert data in removed users table:
	public int insremoveusers(RemovedUsersModel removedusersmodel) throws Exception;

	// fetch users data:
	public List<RemovedUsersModel> fetchremoveusers() throws Exception;

}
