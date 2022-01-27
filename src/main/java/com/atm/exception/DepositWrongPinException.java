package com.atm.exception;

public class DepositWrongPinException extends Exception{
	private static final long serialVersionUID = 1L;

@Override
public String getMessage() {
	return "InvalidPin.jsp";
}
}
