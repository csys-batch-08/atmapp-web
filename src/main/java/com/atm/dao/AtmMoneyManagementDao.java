package com.atm.dao;


import java.sql.SQLException;
import java.util.List;

import com.atm.models.AtmMoneyManagementModel;

public interface AtmMoneyManagementDao {
	//Deposit money Agent:
	public int depositAtmMoney(AtmMoneyManagementModel atmMoneyManagement) throws SQLException;
	
	//History money Deposited Agent:
	public List<AtmMoneyManagementModel> showRefillHistory() throws SQLException;
	
	//previous balance:
	public Long atmPreviousBalance() throws SQLException ;
}
