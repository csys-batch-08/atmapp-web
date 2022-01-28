package com.atm.dao;

import java.sql.SQLException;

import com.atm.models.UsernamePasswordModel;

public interface UsernamePasswordDao {
	// get role:
	public String fetchRole(UsernamePasswordModel usernamepasspojo) throws SQLException;

	// password change:
	public int userPinChange(UsernamePasswordModel usernamepasspojo) throws SQLException;

	// insert user name password:
	public int insertUsernamePasswords(UsernamePasswordModel usernamepasspojo) throws SQLException;

	// remove account:
	public int removeUser(UsernamePasswordModel usernamepasspojo) throws SQLException;
}
