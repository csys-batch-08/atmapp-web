package com.atm.exception;

public class InvalidUsernameAdminException extends Exception{
	private static final long serialVersionUID = 1L;

@Override
public String getMessage() {
	return "invalidUserDetailAdmin.jsp";
}
}
