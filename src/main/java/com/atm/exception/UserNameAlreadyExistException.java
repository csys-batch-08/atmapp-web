package com.atm.exception;

public class UserNameAlreadyExistException extends Exception{
	private static final long serialVersionUID = 1L;

@Override
public String getMessage() {
	return "userNameExist.jsp";
}
}
