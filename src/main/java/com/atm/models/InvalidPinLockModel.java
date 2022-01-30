package com.atm.models;

import java.sql.Timestamp;

public class InvalidPinLockModel {
private int id;
private String userName;
private String accountLockedTime;
private Timestamp accountRetriveTime;


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getAccountLockedTime() {
	return accountLockedTime;
}


public void setAccountLockedTime(String accountLockedTime) {
	this.accountLockedTime = accountLockedTime;
}


public Timestamp getAccountRetriveTime() {
	return accountRetriveTime;
}


public void setAccountRetriveTime(Timestamp accountRetriveTime) {
	this.accountRetriveTime = accountRetriveTime;
}


public InvalidPinLockModel(String userName, Timestamp accountRetriveTime) {
	
	this.userName = userName;
	this.accountRetriveTime = accountRetriveTime;
}


public InvalidPinLockModel(String userName) {
	
	this.userName = userName;
	
}

@Override
public String toString() {
	return "InvalidPinLockModel [id=" + id + ", username=" + userName + ", acclockedat=" + accountLockedTime
			+ ", accretriveat=" + accountRetriveTime + "]";
}

}
