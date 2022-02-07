package com.atm.service;

import java.sql.SQLException;

import com.atm.daoimpl.AtmMoneyManagementImpl;
import com.atm.models.AtmMoneyManagementModel;

public class AtmMoneyManagementService {

	private AtmMoneyManagementService() {

	}

	public static long atmPreviousBalance() {
		AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
		try {
			return atmMoneyManagementimpl.atmPreviousBalance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1l;
	}

	public static void depositeMoney(long eamount, String agent,long prevbal) {
		AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
		try {

			// insert record in table:
			AtmMoneyManagementModel atmMoneyManagement = new AtmMoneyManagementModel(eamount + prevbal, agent);
			atmMoneyManagementimpl.depositAtmMoney(atmMoneyManagement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
