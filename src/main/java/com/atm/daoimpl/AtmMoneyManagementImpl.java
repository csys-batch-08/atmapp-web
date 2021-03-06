package com.atm.daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.atm.dao.AtmMoneyManagementDao;
import com.atm.logger.Logger;
import com.atm.models.AtmMoneyManagementModel;
import com.atm.util.ConnectionUtil;

public class AtmMoneyManagementImpl implements AtmMoneyManagementDao{
	
	String commitString = "commit";
//Deposit money:
	/**
	 * this method is used to insert atmMoneyManagement details into table:
	 */
	public int depositAtmMoney(AtmMoneyManagementModel atmMoneyManagement) throws SQLException{
		
		String depositAtmMoneyQuery = "insert into atm_money_management(money_deposited,money_balance,agent_name) values(?,?,?)";
		String query1 = commitString;
				PreparedStatement statement = null;
				Connection con = null;
				int res = -1;
				try {
					 con = ConnectionUtil.getConnection();
					statement = con.prepareStatement(depositAtmMoneyQuery);
					statement.setLong(1, atmMoneyManagement.getMoneyDeposited());
					statement.setLong(2, atmMoneyManagement.getMoneyDeposited());
					statement.setString(3, atmMoneyManagement.getAgentName());
					 res = statement.executeUpdate();
					statement.executeUpdate(query1);
				} catch (Exception e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
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
	
	//History Agent:
	/**
	 * this method is used to fetch Agent History:
	 */
	public List<AtmMoneyManagementModel> showRefillHistory() throws SQLException {
		List<AtmMoneyManagementModel> atmMoneyManagementModels = new ArrayList<>();
		Connection con = null;
		Statement statement = null;
		ResultSet res = null;
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		try {
			con = ConnectionUtil.getConnection();
			String showRefillHistoryQuery = "select id,money_deposited,money_balance,deposited_at,agent_name from atm_money_management order by id desc";
			statement = con.createStatement();
			 res = statement.executeQuery(showRefillHistoryQuery);
					while(res.next()) {
						atmMoneyManagementModels.add(new AtmMoneyManagementModel(res.getInt("id"),res.getLong("money_deposited"),res.getLong("money_balance"),(res.getTimestamp("deposited_at")).toLocalDateTime().format(dateTimeFormatter),res.getString("agent_name")));
					}
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}finally {
			if(statement != null) {
			statement.close();
			}
			if(res != null) {
				res.close();
			}
			if(con != null) {
				con.close();
			}
			
		}
		
				return atmMoneyManagementModels;
	}
	
	//previous balance:
	/**
	 * this method is used to fetch previous balance of atm:
	 */
	public Long atmPreviousBalance() throws SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet res = null;
		try {
			con = ConnectionUtil.getConnection();
			String atmPreviousBalanceQuery = "select money_balance from atm_money_management where id in (select max(id) from atm_money_management)";
			 statement = con.createStatement();
			 res = statement.executeQuery(atmPreviousBalanceQuery);
					while(res.next()) {
						return res.getLong("money_balance");
					}
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}finally {
			if(statement != null) {
			statement.close();			
			}
			if(res != null) {
				res.close();
			}
			if(con != null) {
				con.close();
			}
			
		}
		
				return -1l;
	}
	
	//update balance:
	/**
	 * this method is used to update balance in atmMoneymanagement table:
	 */
	public int updateNewAtmBalance(AtmMoneyManagementModel atmMoneyManagement) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String updateNewAtmBalanceQuery = "update atm_money_management set money_balance = ? where id in (select max(id) from atm_money_management)";
			String query1 = commitString;
			statement = con.prepareStatement(updateNewAtmBalanceQuery);
					statement.setLong(1, atmMoneyManagement.getMoneyBalance());
					
					res = statement.executeUpdate();
					statement.executeUpdate(query1);
		} catch (Exception e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
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
				
}
