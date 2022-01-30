package com.atm.models;

public class UserProfileModel {
	private int id;
	private String userName;
	private Long userAccountNo;
	private int balance;
	private Long mobileNo;
	private int userPin;
	private String accountCreatedTime;

	

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

	public Long getUserAccountNo() {
		return userAccountNo;
	}

	public void setUserAccountNo(Long userAccountNo) {
		this.userAccountNo = userAccountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getUserPin() {
		return userPin;
	}

	public void setUserPin(int userPin) {
		this.userPin = userPin;
	}

	public String getAccountCreatedTime() {
		return accountCreatedTime;
	}

	public void setAccountCreatedTime(String accountCreatedTime) {
		this.accountCreatedTime = accountCreatedTime;
	}

	public UserProfileModel(int id, String userName, Long userAccountNo, int balance, Long mobileNo, int userPin,
			String accountCreatedTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.userAccountNo = userAccountNo;
		this.balance = balance;
		this.mobileNo = mobileNo;
		this.userPin = userPin;
		this.accountCreatedTime = accountCreatedTime;
	}

	public UserProfileModel(String userName, int balance) {

		this.userName = userName;
		this.balance = balance;
	}

	public UserProfileModel(String userName) {

		this.userName = userName;
	}

	public UserProfileModel(String userName, Long userAccountNo, Long mobileNo, int userPin) {

		this.userName = userName;
		this.userAccountNo = userAccountNo;
		this.mobileNo = mobileNo;
		this.userPin = userPin;
	}
	public UserProfileModel(int userPin,String userName) {

		this.userName = userName;
		this.userPin = userPin;
	}
	public UserProfileModel(Long accountNo) {

		this.userAccountNo = accountNo;
	}
	public UserProfileModel(Long accountNo,int id) {

		this.userAccountNo = accountNo;
		this.id = id;
	}
	public UserProfileModel(Long mobileNo,String s) {

		this.mobileNo = mobileNo;
	}
	public UserProfileModel(String userName, Long accountNo) {

		this.userName = userName;
		this.userAccountNo = accountNo;
	}
	

	@Override
	public String toString() {
		return "Userprofilepojo [id=" + id + ", username=" + userName + ", user_acc_no=" + userAccountNo + ", balance="
				+ balance + ", mob_no=" + mobileNo + ", user_pin=" + userPin + ", acc_created_at=" + accountCreatedTime
				+ "]";
	}

}
