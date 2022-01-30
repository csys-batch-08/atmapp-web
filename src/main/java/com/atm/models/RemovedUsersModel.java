package com.atm.models;

public class RemovedUsersModel {
private int id;
private long userAccountNo;
private String userName;
private int lastBalance;
private long mobileNo;
private int userPin;
private String accountRemovedTime;

public RemovedUsersModel(int id, long userAccountNo, String userName, int lastBalance, long mobileNo, int userPin,
		String accontRemovedTime) {
	super();
	this.id = id;
	this.userAccountNo = userAccountNo;
	this.userName = userName;
	this.lastBalance = lastBalance;
	this.mobileNo = mobileNo;
	this.userPin = userPin;
	this.accountRemovedTime = accontRemovedTime;
}

public RemovedUsersModel(long userAccountNo, String userName, int lastBalance, long mobileNo, int userPin) {
	
	this.userAccountNo = userAccountNo;
	this.userName = userName;
	this.lastBalance = lastBalance;
	this.mobileNo = mobileNo;
	this.userPin = userPin;
}



public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public long getUserAccountNo() {
	return userAccountNo;
}


public void setUserAccountNo(long userAccountNo) {
	this.userAccountNo = userAccountNo;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public int getLastBalance() {
	return lastBalance;
}


public void setLastBalance(int lastBalance) {
	this.lastBalance = lastBalance;
}


public long getMobileNo() {
	return mobileNo;
}


public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}


public int getUserPin() {
	return userPin;
}


public void setUserPin(int userPin) {
	this.userPin = userPin;
}


public String getAccountRemovedTime() {
	return accountRemovedTime;
}


public void setAccountRemovedTime(String accontRemovedTime) {
	this.accountRemovedTime = accontRemovedTime;
}


@Override
public String toString() {
	return "Removedusersmodel [id=" + id + ", useraccno=" + userAccountNo + ", username=" + userName + ", lastbalance="
			+ lastBalance + ", mobno=" + mobileNo + ", userpin=" + userPin + ", accremovedat=" + accountRemovedTime + "]";
}


}
