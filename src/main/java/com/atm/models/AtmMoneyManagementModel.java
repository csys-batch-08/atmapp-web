package com.atm.models;

public class AtmMoneyManagementModel {
	private int id;
	private Long moneyDeposited;
	private Long moneyBalance;
	private String depositedTime;
	private String agentName;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getMoneyDeposited() {
		return moneyDeposited;
	}
	public void setMoneyDeposited(Long moneyDeposited) {
		this.moneyDeposited = moneyDeposited;
	}
	public Long getMoneyBalance() {
		return moneyBalance;
	}
	public void setMoneyBalance(Long moneyBalance) {
		this.moneyBalance = moneyBalance;
	}
	public String getDepositedTime() {
		return depositedTime;
	}
	public void setDepositedTime(String depositedTime) {
		this.depositedTime = depositedTime;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public AtmMoneyManagementModel(int id, Long moneyDeposited, Long moneyBalance, String depositedTime, String agentName) {

		this.id = id;
		this.moneyDeposited = moneyDeposited;
		this.moneyBalance = moneyBalance;
		this.depositedTime = depositedTime;
		this.agentName = agentName;
	}
	public AtmMoneyManagementModel() {

		
	}

	@Override
	public String toString() {
		return "AtmMoneyManagement [id=" + id + ", moneydeposited=" + moneyDeposited + ", moneybalance=" + moneyBalance
				+ ", depositedat=" + depositedTime + ", agentname=" + agentName + "]";
	}

	public AtmMoneyManagementModel(Long moneyDeposited, String agentName) {

		this.moneyDeposited = moneyDeposited;
		this.agentName = agentName;
	}
	
	public AtmMoneyManagementModel(Long moneyBalance) {

		this.moneyBalance = moneyBalance;
		
	}
	

}
