package com.atm.daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.atm.dao.LoginDetailsDao;
import com.atm.logger.Logger;
import com.atm.models.LoginDetailsModel;
import com.atm.util.ConnectionUtil;


public class LoginDetailsImpl implements LoginDetailsDao {
	String commitString = "commit";
	// Remove Account:
	/**
	 * this method is used to delete user from login details for given username:
	 */
	public int removeLoginDetails(LoginDetailsModel loginpojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "delete from login where username in ?";
			String query1 = commitString;
			statement = con.prepareStatement(query);
			statement.setString(1, loginpojo.getUserName());
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

	// Insert Data in to login table:
	/**
	 * this method is used to insert login details:
	 */
	public int insertLoginDetails(LoginDetailsModel loginpojo) throws SQLException {

		Connection con = null;
		PreparedStatement statement = null;
		int res= -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "insert into login(username,role) values(?,?)";
			String query1 = commitString;
			statement = con.prepareStatement(query);
			statement.setString(1, loginpojo.getUserName());
			statement.setString(2, loginpojo.getRole());
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
	
	//fetch login details:
	/**
	 * this method is used to fetch login details:
	 */
	public List<LoginDetailsModel> fetchLoginDetails()throws SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rSet = null;
		List<LoginDetailsModel> loginDetailsModels = new ArrayList<>();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		try {
			con = ConnectionUtil.getConnection();
		String query = "select id,username,logged_at,role from login order by logged_at desc";
		statement = con.createStatement();
		 rSet = statement.executeQuery(query);
		
		while(rSet.next()) {
			loginDetailsModels.add(new LoginDetailsModel(rSet.getInt("id"), rSet.getString("username"), (rSet.getTimestamp("logged_at")).toLocalDateTime().format(dateTimeFormatter), rSet.getString("role")));
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
			if(con != null) {
				con.close();
			}
		}
		return loginDetailsModels;

}
}
