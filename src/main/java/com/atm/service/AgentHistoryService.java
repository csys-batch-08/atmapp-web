package com.atm.service;

import java.sql.SQLException;
import java.util.List;

import com.atm.daoimpl.AtmMoneyManagementImpl;
import com.atm.logger.Logger;
import com.atm.models.AtmMoneyManagementModel;

public class AgentHistoryService {

	private AgentHistoryService() {
		
	}
	public static List<AtmMoneyManagementModel> showRefillHistory() {
		AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
		List<AtmMoneyManagementModel> atmMoneyManagementModels = null;
		try {
			atmMoneyManagementModels = atmMoneyManagementimpl.showRefillHistory();
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
		return atmMoneyManagementModels;
	}
}
