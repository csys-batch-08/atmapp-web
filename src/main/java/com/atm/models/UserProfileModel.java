package com.atm.models;

public class UserProfileModel {
	private int id;
	private String username;
	private Long useraccno;
	private int balance;
	private Long mobno;
	private int userpin;
	private String acccreatedat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUseraccno() {
		return useraccno;
	}

	public void setUseraccno(Long user_acc_no) {
		this.useraccno = user_acc_no;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Long getMobno() {
		return mobno;
	}

	public void setMobno(Long mob_no) {
		this.mobno = mob_no;
	}

	public int getUserpin() {
		return userpin;
	}

	public void setUserpin(int user_pin) {
		this.userpin = user_pin;
	}

	public String getAcccreatedat() {
		return acccreatedat;
	}

	public void setAcccreatedat(String acccreatedat) {
		this.acccreatedat = acccreatedat;
	}

	public UserProfileModel(int id, String username, Long useraccno, int balance, Long mobno, int userpin,
			String acccreatedat) {
		super();
		this.id = id;
		this.username = username;
		this.useraccno = useraccno;
		this.balance = balance;
		this.mobno = mobno;
		this.userpin = userpin;
		this.acccreatedat = acccreatedat;
	}

	public UserProfileModel(String username, int balance) {

		this.username = username;
		this.balance = balance;
	}

	public UserProfileModel(String username) {

		this.username = username;
	}

	public UserProfileModel(String username, Long useraccno, Long mobno, int userpin) {

		this.username = username;
		this.useraccno = useraccno;
		this.mobno = mobno;
		this.userpin = userpin;
	}
	public UserProfileModel(int userpin,String username) {

		this.username = username;
		this.userpin = userpin;
	}
	public UserProfileModel(Long accno) {

		this.useraccno = accno;
	}
	public UserProfileModel(Long accno,int id) {

		this.useraccno = accno;
		this.id = id;
	}
	public UserProfileModel(Long mob_no,String s) {

		this.mobno = mob_no;
	}
	public UserProfileModel(String username, Long useracno) {

		this.username = username;
		this.useraccno = useracno;
	}
	

	@Override
	public String toString() {
		return "Userprofilepojo [id=" + id + ", username=" + username + ", user_acc_no=" + useraccno + ", balance="
				+ balance + ", mob_no=" + mobno + ", user_pin=" + userpin + ", acc_created_at=" + acccreatedat
				+ "]";
	}

}
