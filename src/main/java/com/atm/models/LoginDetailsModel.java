package com.atm.models;

import java.util.Objects;

public class LoginDetailsModel {
	private int id;
	private String userName;
	private String loggedTime;
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

	public String getLoggedTime() {
		return loggedTime;
	}

	public void setLoggedTime(String loggedTime) {
		this.loggedTime = loggedTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LoginDetailsModel(int id, String userName, String loggedTime, String role) {

		this.id = id;
		this.userName = userName;
		this.loggedTime = loggedTime;
		this.role = role;
	}

	public LoginDetailsModel(String userName) {
		this.userName = userName;
	}

	public LoginDetailsModel(String userName, String role) {
		this.userName = userName;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Loginpojo [Id=" + id + ", username=" + userName + ", logged_at=" + loggedTime + ", Role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, role, loggedTime, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDetailsModel other = (LoginDetailsModel) obj;
		return id == other.id && Objects.equals(role, other.role) && Objects.equals(loggedTime, other.loggedTime)
				&& Objects.equals(userName, other.userName);
	}

}
