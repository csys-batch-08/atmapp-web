package com.atm.models;

public class DepositModel {
	private int id;
	private Long userAccountNo;
	private int depositAmount;
	private String depositTime;
	private String moneyTransfer;

	@Override
	public String toString() {
		return "Depositpojo [id=" + id + ", user_acc_no=" + userAccountNo + ", dep_amount=" + depositAmount + ", dep_at="
				+ depositTime + "]";
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Long getUserAccountNo() {
		return userAccountNo;
	}



	public void setUserAccountNo(Long userAccountNo) {
		this.userAccountNo = userAccountNo;
	}



	public int getDepositAmount() {
		return depositAmount;
	}



	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}



	public String getDepositTime() {
		return depositTime;
	}



	public void setDepositTime(String depositTime) {
		this.depositTime = depositTime;
	}



	public String getMoneyTransfer() {
		return moneyTransfer;
	}



	public void setMoneyTransfer(String moneyTransfer) {
		this.moneyTransfer = moneyTransfer;
	}



	public DepositModel(int id, Long userAccountNo, int depositAmount, String depositTime) {

		this.id = id;
		this.userAccountNo = userAccountNo;
		this.depositAmount = depositAmount;
		this.depositTime = depositTime;
	}

	public DepositModel(Long userAccountNo, int depositAmount) {

		this.userAccountNo = userAccountNo;
		this.depositAmount = depositAmount;

	}

	public DepositModel(Long userAccountNo) {

		this.userAccountNo = userAccountNo;

	}
	
	public DepositModel(Long userAccountNo, int depositAmount,String moneyTransfName) {

		this.userAccountNo = userAccountNo;
		this.depositAmount = depositAmount;
this.moneyTransfer = moneyTransfName;
	}
	
	public DepositModel() {

	
	}

}
