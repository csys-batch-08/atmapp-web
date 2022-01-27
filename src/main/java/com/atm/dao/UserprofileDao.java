package com.atm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.atm.models.UserProfileModel;

public interface UserprofileDao {
	// get balance:
	public int getbal(UserProfileModel userprofilepojo) throws SQLException;

	// ins balance:
	public int insbal(UserProfileModel userprofilepojo) throws SQLException;

	// get account no:
	public Long getaccno(UserProfileModel userprofilepojo) throws SQLException;

	// get user details:
	public List<UserProfileModel> getuserdetails(UserProfileModel userprofilepojo) throws SQLException;

	// insert user profile details:
	public int insuserprofile(UserProfileModel userprofilepojo) throws SQLException;

	// get user details All
	public ResultSet getuserdetails() throws SQLException;

	// remove account:
	public int removeuserprof(UserProfileModel userprofilepojo) throws SQLException;

	// get max account:
	public long getusermaxacc() throws SQLException;

	// get max pin:
	public int getusermaxpin() throws SQLException;

	// get user pin:
	public int getuserpin(String username) throws SQLException;
}
