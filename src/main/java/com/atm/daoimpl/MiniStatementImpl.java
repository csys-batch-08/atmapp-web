package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.atm.dao.MiniStatementDao;
import com.atm.logger.Logger;
import com.atm.models.TransActionsModel;
import com.atm.util.ConnectionUtil;

public class MiniStatementImpl implements MiniStatementDao {
	// Get MiniStatement:
	/**
	 * this method is used to fetch users last 10 transactions:
	 */
	public List<TransActionsModel> fetchMiniStatement(Long accno) throws SQLException {
		List<TransActionsModel> miniStatement = new ArrayList<>(); 
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rSet = null;
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		try {
			connection = ConnectionUtil.getConnection();
			String query = "select user_acc_no,transaction_amount,transaction_at,transaction_type,money_transfer from transactions where user_acc_no in ? order by transaction_at desc fetch first 10 rows only";
			statement = connection.prepareStatement(query);
			statement.setLong(1, accno);
			
			 rSet = statement.executeQuery();
			while(rSet.next()) {
				
				String transtype = null;
				if(rSet.getString(5) != null){
				transtype = rSet.getString(5);
			 }else{
			transtype = rSet.getString(4); 
			 }
				miniStatement.add(new TransActionsModel(rSet.getInt("transaction_amount"),(rSet.getTimestamp("transaction_at")).toLocalDateTime().format(dateTimeFormatter),transtype));
			}
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}finally {
			if(statement != null) {
				statement.close();
				}
			if(rSet != null) {
				rSet.close();
			}
				if(connection != null) {
					connection.close();
				}
			}		
		return miniStatement;
	}
}
