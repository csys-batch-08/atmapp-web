package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atm.logger.Logger;
import com.atm.models.InvalidPinLockModel;
import com.atm.util.ConnectionUtil;

public class InvalidPinLockDaoimpl {
	String commitString = "commit";
	String regexTimeString = "[0][0-9]";
	//Insert invalidPinLock data in table:
	/**
	 * this method is used to insert user data in invalidPinLock table:
	 */
public int insertInavalidPinLock(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	int res = -1;
	try {
		con = ConnectionUtil.getConnection();
		String query = "insert into invalidpinlock(username) values(?)";
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUserName());
		
		 res = statement.executeUpdate();
		statement.executeUpdate(commitString);
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

//check whether the acc is locked or not:
/**
 * this method is used to check whether the user is locked or not for given username:
 */
public boolean invalidPinLockStatus(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	ResultSet rSet = null;
	try {
		con = ConnectionUtil.getConnection();
		String query = "select id from invalidpinlock where username in ?";
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUserName());
		rSet = statement.executeQuery();
		if(rSet.next()) {
			return true;
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
	
	return false;
}
//delete entries from table:
/**
 * this method is used to delete invalidPinLock users:
 */
public int deleteInvalidPinLock(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	int res = -1;
	try {
		con = ConnectionUtil.getConnection();
		String query = "delete from invalidpinlock where username in ?";
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUserName());
		 res = statement.executeUpdate();
		statement.executeUpdate(commitString);
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


//retrive date : 
/**
 * this method is used to get deducted date:
 */
public int getCurrentDate(InvalidPinLockModel invalidPinLockModel) throws SQLException{
	Connection con = null;
	PreparedStatement statement = null;
	int date = 0;
	ResultSet rSet1 = null;
	try {
		con = ConnectionUtil.getConnection();
		//calculate days:
		String datequery = "select substr((current_timestamp-acc_lockedat),2,2) from invalidpinlock where username in ?";
		//date:
		statement = con.prepareStatement(datequery);
				statement.setString(1, invalidPinLockModel.getUserName());
				
				 rSet1 = statement.executeQuery();
				while(rSet1.next()) {
					String ret = rSet1.getString(1);
					if(ret.matches(regexTimeString)) {
					 date = Integer.parseInt(ret.substring(1));				
					}else {						
					 date = Integer.parseInt(rSet1.getString(1));
					}
				}
}catch (Exception e) {
	Logger.printStackTrace(e);
	Logger.runTimeException(e.getMessage());
}finally {
	if(statement != null) {
	statement.close();	
	}
	if(rSet1 != null) {
		rSet1.close();
	}
	if(con != null) {
		con.close();
	}
}
return date;
}

//retrive hours: 
/**
 * this method is used to get deducted hour:
 */
public int getCurrentHour(InvalidPinLockModel invalidPinLockModel) throws SQLException{
	Connection con = null;
	int hours = 0;
	PreparedStatement statement = null;
	ResultSet rSet2 = null;
	try {
		con = ConnectionUtil.getConnection();
		//calculate hours:
				String hoursqueryString = "select substr((current_timestamp-acc_lockedat),5,2) from invalidpinlock where username in ?";
		//hours:
		statement = con.prepareStatement(hoursqueryString);
				statement.setString(1, invalidPinLockModel.getUserName());
				
				 rSet2 = statement.executeQuery();
				while(rSet2.next()) {
					String ret = rSet2.getString(1);
					if(ret.matches(regexTimeString)) {
					 hours = Integer.parseInt(ret.substring(1));
					
					}else {
					 hours = Integer.parseInt(rSet2.getString(1));
					}
				}
	}catch (Exception e) {
		Logger.printStackTrace(e);
		Logger.runTimeException(e.getMessage());
	}finally {
		if(statement != null) {
			statement.close();			
			}
		if(rSet2 != null) {
			rSet2.close();
		}
			if(con != null) {
				con.close();
			}
		}
	return hours;
}
		

//retrive the releasing time:
/**
 * this method is used to retrive the account lock releasing time:
 */
public int accountLockReleaseAt(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	ResultSet rSet = null;
	try {
		con = ConnectionUtil.getConnection();
		//calculate minutes:
		String query = "select substr((current_timestamp-acc_lockedat),-12,2) from invalidpinlock where username in ?";
		int date = getCurrentDate(invalidPinLockModel);
		int hours = getCurrentHour(invalidPinLockModel);
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUserName());
		rSet = statement.executeQuery();
		while(rSet.next()) {
			String ret = rSet.getString(1);
			if(date < 1) {
				if(hours < 1) {
			if(ret.matches(regexTimeString)) {
			return Integer.parseInt(ret.substring(1));
			}else {
				return Integer.parseInt(ret);
			}
		}else {
			return 100;
		}
				}else {
			return 100;
		}
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
	return -1;
}
}

