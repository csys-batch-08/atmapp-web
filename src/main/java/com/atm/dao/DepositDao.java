package com.atm.dao;

import java.sql.SQLException;

import com.atm.models.DepositModel;

public interface DepositDao {
	// insert deposit:
	public int insdep(DepositModel depositpojo) throws SQLException;

	// remove account:
	public int removedep(DepositModel depositpojo) throws SQLException;
	
	//check Deposit limit:
			public int checkwithdrawlimit(DepositModel depositModel) throws SQLException;
}
