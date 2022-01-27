package com.atm.dao;

import java.sql.SQLException;

import com.atm.models.UsernamePasswordModel;

public interface UsernamePasswordDao {
	// get role:
	public String getrole(UsernamePasswordModel usernamepasspojo) throws SQLException;

	// password change:
	public int pinchange(UsernamePasswordModel usernamepasspojo) throws SQLException;

	// insert user name password:
	public int insusernamepass(UsernamePasswordModel usernamepasspojo) throws SQLException;

	// remove account:
	public int removeuser(UsernamePasswordModel usernamepasspojo) throws SQLException;
}
