package com.atm.exception;

public class MobileNoAlreadyRegException extends Exception{

	private static final long serialVersionUID = 1L;

@Override
public String getMessage() {
	return "mobileNoExist.jsp";
}
}
