package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.atm.models.TransActionsModel;

import com.atm.util.ConnectionUtil;

public class TransActionsImpl {
	
	// Insert TransAction Data:
		public int insertTransAction(TransActionsModel transActionsModel) throws SQLException {
			Connection con = null;
			int res = -1;
			PreparedStatement statement = null;
			try {
				con = ConnectionUtil.getConnection();
				String query = "insert into transactions(user_acc_no,transaction_amount,transaction_type,money_transfer) values(?,?,?,?)";
				String query1 = "commit";
				statement = con.prepareStatement(query);
				statement.setLong(1, transActionsModel.getUserAccnoLong());
				statement.setInt(2, transActionsModel.getTransActionAmount());
				statement.setString(3, transActionsModel.getTransActionType());
				statement.setString(4, transActionsModel.getMoneyTransfer());
				res = statement.executeUpdate();
				statement.executeUpdate(query1);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(statement != null) {
					statement.close();
					}
					if(con != null) {
						con.close();
					}
				}
			return res;
}
		
		// Remove account:
		public int removeTransActions(TransActionsModel transActionsModel) throws SQLException {
			Connection con = null;
			int res = -1;
			PreparedStatement statement = null;
			try {
				con = ConnectionUtil.getConnection();
				String query = "delete from transactions where user_acc_no in ?";
				String query1 = "commit";
				statement = con.prepareStatement(query);
				statement.setLong(1, transActionsModel.getUserAccnoLong());
				 res = statement.executeUpdate();
				statement.executeUpdate(query1);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(statement != null) {
					statement.close();
					}
					if(con != null) {
						con.close();
					}
				}
			return res;
		}
		
		public String withdrawCurrentTimeStamp() throws SQLException{
			Connection con = null;
			String sysdString = null;
	        String finaldateString = null;
	        Statement statement = null;
			try {
				con = ConnectionUtil.getConnection();
				 String sysdatequery = "select current_timestamp from dual";  
			        statement
			        = con.createStatement();
			        ResultSet rSet = statement.executeQuery(sysdatequery);
			        while(rSet.next()) {
			        	sysdString = rSet.getString(1);
			        	
			        }
			        if(sysdString != null) {
			        sysdString = sysdString.substring(2, 10);	      
			        String yearString = sysdString.substring(0,2);	       
			        String monthString = sysdString.substring(3,5);	       
			        String dayString = sysdString.substring(6,8);	      
			        finaldateString = dayString + "-" +monthString + "-" + yearString;
			        }
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(statement != null) {
					statement.close();
					}
					if(con != null) {
						con.close();
					}
				}
	       
	        return finaldateString;
		}
		//check withdraw limit:
		public int checkwithdrawlimit(TransActionsModel transActionsModel) throws SQLException {
			Connection con = null;
			int total = -1;
			PreparedStatement preparedStatement = null;
			 String finaldateString = withdrawCurrentTimeStamp() + "%"; 
			try {
				con = ConnectionUtil.getConnection();

					String query = "select sum(abs(transaction_amount)) from transactions where transaction_at like ? and user_acc_no in ? and transaction_type = 'withdraw'";
					preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, finaldateString);
					preparedStatement.setLong(2,  transActionsModel.getUserAccnoLong());
					ResultSet rSet2 = preparedStatement.executeQuery();
					total = -1;
					while(rSet2.next()) {
			        	total = rSet2.getInt(1);
			        	return total;
			        }
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(preparedStatement != null) {
					preparedStatement.close();
					}
					if(con != null) {
						con.close();
					}
				}		
			return total;
		}
		
		public String depositCurrentTimeStamp() throws SQLException{
			Connection con = null;
			String finaldateString = null;
			Statement statement = null;
			try {
				con = ConnectionUtil.getConnection();
				 String sysdatequery = "select current_timestamp from dual";
			        String sysdString = null;
			        statement  = con.createStatement();
			        ResultSet rSet = statement.executeQuery(sysdatequery);
			        while(rSet.next()) {
			        	sysdString = rSet.getString(1);			        	
			        }
			        if(sysdString != null) {
			        sysdString = sysdString.substring(2, 10);			        
			        String yearString = sysdString.substring(0,2);			       
			        String monthString = sysdString.substring(3,5);			       
			        String dayString = sysdString.substring(6,8);
			         finaldateString = dayString + "-" +monthString + "-" + yearString;
			        }
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(statement != null) {
					statement.close();
					}
					if(con != null) {
						con.close();
					}
				}
	       return finaldateString;
		}
		
		
		//check deposit limit:
		
				public int checkDepositLimit(TransActionsModel transActionsModel) throws SQLException {
					Connection con = null;
					PreparedStatement preparedStatement = null;
					int total = -1;
					 String finaldateString = depositCurrentTimeStamp() + "%";
					try {
						con = ConnectionUtil.getConnection();			        
						String query = "select sum(abs(transaction_amount)) from transactions where transaction_at like ? and user_acc_no in ? and transaction_type = 'deposit'";
						preparedStatement = con.prepareStatement(query);	
						preparedStatement.setString(1, finaldateString);
						preparedStatement.setLong(2,  transActionsModel.getUserAccnoLong());
						ResultSet rSet2 = preparedStatement.executeQuery();
						if(rSet2.next()) {
				        	total = rSet2.getInt(1);
				        	return total;
				        }
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						if(preparedStatement != null) {
							preparedStatement.close();
							}
							if(con != null) {
								con.close();
							}
						}					
					return total;
				}
}
