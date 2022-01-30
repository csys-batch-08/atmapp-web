package com.atm.models;

public class UsernamePasswordModel {
	private int id;
	private String userName;
	private String password;
	private String createdTime;
	private String role;

	

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UsernamePasswordModel(int id, String userName, String password, String createdTime, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.createdTime = userName;
		this.role = role;
	}

	public UsernamePasswordModel(String userName, String password) {

		this.userName = userName;
		this.password = password;
	}

	public UsernamePasswordModel(String userName) {

		this.userName = userName;
	}

	public UsernamePasswordModel(String userName, String password, String role) {

		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Usernamepasspojo [id=" + id + ", username=" + userName + ", password=" + password + ", created_at="
				+ createdTime + ", role=" + role + "]";
	}

}
