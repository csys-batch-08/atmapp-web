package com.atm.exception;

public class LowBalanceException extends Exception{
	private static final long serialVersionUID = 1L;

@Override
public String getMessage() {
	return "lowBalance.jsp";
}
}
