package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.jar.Manifest;

import com.atm.models.InvalidPinLockModel;
import com.atm.util.ConnectionUtil;

public class InvalidPinLockDaoimpl {
	//Insert data in table:
public int insertInavalidPinLock(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	int res = -1;
	try {
		con = ConnectionUtil.getConnection();
		String query = "insert into invalidpinlock(username) values(?)";
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUsername());
		
		 res = statement.executeUpdate();
		statement.executeUpdate("commit");
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

//check whether the acc is locked or not:
public boolean invalidPinLockStatus(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	try {
		con = ConnectionUtil.getConnection();
		String query = "select * from invalidpinlock where username in ?";
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUsername());
		ResultSet rSet = statement.executeQuery();
		if(rSet.next()) {
			return true;
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
	
	return false;
}
//delete entries from table:

public int deleteInvalidPinLock(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	int res = -1;
	try {
		con = ConnectionUtil.getConnection();
		String query = "delete from invalidpinlock where username in ?";
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUsername());
		 res = statement.executeUpdate();
		statement.executeUpdate("commit");
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


//retrive date : 
public int getCurrentDate(InvalidPinLockModel invalidPinLockModel) throws SQLException{
	Connection con = null;
	PreparedStatement statement = null;
	int date = 0;
	try {
		con = ConnectionUtil.getConnection();
		//calculate days:
		String datequery = "select substr((current_timestamp-acc_lockedat),2,2) from invalidpinlock where username in ?";
		//date:
		statement = con.prepareStatement(datequery);
				statement.setString(1, invalidPinLockModel.getUsername());
				
				ResultSet rSet1 = statement.executeQuery();
				while(rSet1.next()) {
					String ret = rSet1.getString(1);
					if(ret.matches("[0][0-9]")) {
					 date = Integer.parseInt(ret.substring(1));				
					}else {						
					 date = Integer.parseInt(rSet1.getString(1));
					}
				}
}catch (Exception e) {
	e.getMessage();
}finally {
	if(statement != null) {
	statement.close();
	
	}
	if(con != null) {
		con.close();
	}
}
return date;
}

//retrive hours: 
public int getCurrentHour(InvalidPinLockModel invalidPinLockModel) throws SQLException{
	Connection con = null;
	int hours = 0;
	PreparedStatement statement = null;
	try {
		con = ConnectionUtil.getConnection();
		//calculate hours:
				String hoursqueryString = "select substr((current_timestamp-acc_lockedat),5,2) from invalidpinlock where username in ?";
		//hours:
		statement = con.prepareStatement(hoursqueryString);
				statement.setString(1, invalidPinLockModel.getUsername());
				
				ResultSet rSet2 = statement.executeQuery();
				while(rSet2.next()) {
					String ret = rSet2.getString(1);
					if(ret.matches("[0][0-9]")) {
					 hours = Integer.parseInt(ret.substring(1));
					
					}else {
					 hours = Integer.parseInt(rSet2.getString(1));
					}
				}
	}catch (Exception e) {
		e.getMessage();
	}finally {
		if(statement != null) {
			statement.close();
			
			}
			if(con != null) {
				con.close();
			}
		}
	return hours;
}
		

//retrive the releasing time:
public int accountLockReleaseAt(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	try {
		con = ConnectionUtil.getConnection();
		//calculate minutes:
		String query = "select substr((current_timestamp-acc_lockedat),-12,2) from invalidpinlock where username in ?";
		int date = getCurrentDate(invalidPinLockModel);
		int hours = getCurrentHour(invalidPinLockModel);
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUsername());
		ResultSet rSet = statement.executeQuery();
		while(rSet.next()) {
			String ret = rSet.getString(1);
			if(date < 1) {
				if(hours < 1) {
			if(ret.matches("[0][0-9]")) {
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
}

