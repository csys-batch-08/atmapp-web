package com.atm.service;

import java.sql.SQLException;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.logger.Logger;
import com.atm.models.UserProfileModel;

public class BalanceService {

	private BalanceService() {
		
	}
	public static int getUserBalance(String user) {
	
	UserProfileImpl userProfiledao = new UserProfileImpl();
	UserProfileModel userprofilepojo = new UserProfileModel(user);
	int balance = 0;
		try {
			balance = userProfiledao.getUserBalance(userprofilepojo);
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
		return balance;
	}
}
