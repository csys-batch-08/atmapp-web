package com.atm.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.atm.dao.UserprofileDao;
import com.atm.models.UserProfileModel;
import com.atm.util.ConnectionUtil;

public class UserProfileImpl implements UserprofileDao {

	private String commitString = "commit";
	// Get Balance:
	public int getUserBalance(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		int res = -1;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select balance from userprofile where username in ?";
			statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUserName());
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				res = rSet.getInt(1);
			}
		} catch (Exception e) {
			e.getMessage();
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

	// update balance:
	public int insertUserBalance(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		int res = -1;
		PreparedStatement statement = null; 
		try {
			con = ConnectionUtil.getConnection();
			String query = "update userprofile set balance = ? where username in ?";
			String query1 = commitString;
			statement = con.prepareStatement(query);
			statement.setInt(1, userprofilepojo.getBalance());
			statement.setString(2, userprofilepojo.getUserName());
			 res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			e.getMessage();
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

	// get Account number:
	public Long getAccountNo(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		Long resLong = -1l;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select user_acc_no from userprofile where username in ?";
			statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUserName());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				resLong = rs.getLong(1);
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
		}
		
		return resLong;
	}

	// get user details:
	public List<UserProfileModel> fetchUserDetails(UserProfileModel userprofilepojo) throws SQLException {
		List<UserProfileModel> userProfileModels = new ArrayList<>();
		Connection con = null;
		PreparedStatement statement = null;
		
		try {
			con = ConnectionUtil.getConnection();
			String query = "select id,username,user_acc_no,balance,mob_no,user_pin,acc_created_at from userprofile where username in ?";
			statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUserName());
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				userProfileModels.add(new UserProfileModel(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getInt(4), rs.getLong(5), rs.getInt(6), rs.getString(7)));
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
		}
		return userProfileModels;
	}

	// insert user profile details:
	public int insertUserProfile(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		int res = -1;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "insert into userprofile(username,user_acc_no,mob_no,user_pin) values(?,?,?,?)";
			String query1 = commitString;
			statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUserName());
			statement.setLong(2, userprofilepojo.getUserAccountNo());
			statement.setLong(3, userprofilepojo.getMobileNo());
			statement.setInt(4, userprofilepojo.getUserPin());
			res = statement.executeUpdate();
			 statement.executeUpdate(query1);
		} catch (Exception e) {
			e.getMessage();
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

	// get user details All:
	public ResultSet fetchUserDetails() throws SQLException {
		Connection con = null;
		Statement statement = null; 
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();

			String query = "select id,username,user_acc_no,balance,mob_no,user_pin,acc_created_at  from userprofile";
			statement = con.createStatement();
			 rs = statement.executeQuery(query);
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
		}

		return rs;
	}

	// remove account:
	public int removeUserProfile(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "delete from userprofile where user_acc_no in ? and id in ?";
			String query1 = commitString;
			statement = con.prepareStatement(query);
			statement.setLong(1, userprofilepojo.getUserAccountNo());
			statement.setInt(2, userprofilepojo.getId());
			res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			e.getMessage();
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

	// get max account:
	public long getUserMaximumAccountNo() throws SQLException {
		Connection con = null;
		long accno = -1l;
		Statement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select max(user_acc_no) from userprofile";
			 statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				accno = rs.getLong(1);
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
		}
		return accno;
	}

	// get max pin:
	public int getUserMaximumPin() throws SQLException {
		int pin = -1;
		Connection con = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select max(user_pin) from userprofile";
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				pin = rs.getInt(1);
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
		}
		return pin;
	}

	// get user_pin:
	public int getUserPin(String username) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select user_pin from userprofile where username in ?";
			statement = con.prepareStatement(query);
			statement.setString(1, username);

			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
		}

		return -1;
		
	}

	public int moneyTransfer(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		int res = -1;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select balance from userprofile where username in ? and user_acc_no in ?";
			statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUserName());
			statement.setLong(2, userprofilepojo.getUserAccountNo());
			ResultSet rSet = statement.executeQuery();

			if (rSet.next()) {
				res = rSet.getInt(1);
			}
		} catch (Exception e) {
			e.getMessage();
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
	
	//update User Pin:
	public int updateUserPin(UserProfileModel userProfileModel) throws SQLException {
		Connection con = null;
		PreparedStatement pStatement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "update userprofile set user_pin = ? where username in ?";
			pStatement = con.prepareStatement(query);
			pStatement.setInt(1, userProfileModel.getUserPin());
			pStatement.setString(2, userProfileModel.getUserName());
			res= pStatement.executeUpdate();
			pStatement.executeUpdate(commitString);
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(pStatement != null) {
				pStatement.close();
				}
				if(con != null) {
					con.close();
				}
		}
	
		return res;
		
	}
	
	//check usermobile no exist:
	public boolean userMobileNoExistCheck(UserProfileModel userProfileModel)throws SQLException {
		Connection con = null;
		PreparedStatement pStatement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select id,username,user_acc_no,balance,mob_no,user_pin,acc_created_at from userprofile where mob_no in ?";
			pStatement = con.prepareStatement(query);
			pStatement.setLong(1, userProfileModel.getMobileNo());
			ResultSet rSet = pStatement.executeQuery();
			if(rSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(pStatement != null) {
				pStatement.close();
				}
				if(con != null) {
					con.close();
				}
		}	
		return false;
	}
	

}
