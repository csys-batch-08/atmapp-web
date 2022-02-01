package com.atm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.atm.models.UserProfileModel;

public interface UserprofileDao {
	// get balance:
	public int getUserBalance(UserProfileModel userprofilepojo) throws SQLException;

	// ins balance:
	public int insertUserBalance(UserProfileModel userprofilepojo) throws SQLException;

	// get account no:
	public Long getAccountNo(UserProfileModel userprofilepojo) throws SQLException;

	// get user details:
	public List<UserProfileModel> fetchUserDetails(UserProfileModel userprofilepojo) throws SQLException;

	// insert user profile details:
	public int insertUserProfile(UserProfileModel userprofilepojo) throws SQLException;

	// get user details All
	public List<UserProfileModel> fetchUserDetails() throws SQLException;

	// remove account:
	public int removeUserProfile(UserProfileModel userprofilepojo) throws SQLException;

	// get max account:
	public long getUserMaximumAccountNo() throws SQLException;

	// get max pin:
	public int getUserMaximumPin() throws SQLException;

	// get user pin:
	public int getUserPin(String username) throws SQLException;
}
