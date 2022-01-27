package com.atm.dao;

import java.sql.SQLException;
import java.util.List;

import com.atm.models.LoginDetailsModel;

public interface LoginDetailsDao {
	// remove login details:
	public int removeLoginDetails(LoginDetailsModel loginpojo) throws SQLException;

	// Insert Data in to login table:
	public int insertLoginDetails(LoginDetailsModel loginpojo) throws SQLException;
	
	//fetch login details:
		public List<LoginDetailsModel> fetchLoginDetails()throws SQLException;
}
