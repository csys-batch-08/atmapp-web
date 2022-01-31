package com.atm.dao;

import java.sql.SQLException;

import com.atm.models.TransActionsModel;

public interface TransActionsDao {

	public int insertTransAction(TransActionsModel transActionsModel) throws SQLException ;
	public int removeTransActions(TransActionsModel transActionsModel) throws SQLException ;
	public String withdrawCurrentTimeStamp() throws SQLException;
	public int checkwithdrawlimit(TransActionsModel transActionsModel) throws SQLException;
	public String depositCurrentTimeStamp() throws SQLException;
	public int checkDepositLimit(TransActionsModel transActionsModel) throws SQLException;
}
