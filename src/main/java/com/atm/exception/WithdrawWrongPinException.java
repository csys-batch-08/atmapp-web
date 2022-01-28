package com.atm.exception;

public class WithdrawWrongPinException extends Exception{

	private static final long serialVersionUID = 1L;

@Override
public String getMessage() {
	
	return "invalidPin.jsp";
}
}
