package com.atm.dao;


import java.sql.SQLException;
import java.util.List;

import com.atm.models.TransActionsModel;

public interface MiniStatementDao {
	// Get MiniStatement:
		public List<TransActionsModel> fetchMiniStatement(Long accno) throws SQLException;
}
