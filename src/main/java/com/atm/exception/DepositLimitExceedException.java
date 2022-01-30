package com.atm.exception;

public class DepositLimitExceedException extends Exception{
	private static final long serialVersionUID = 1L;

@Override
public String getMessage() {
	return "depositLimitExceed.jsp";
}
}
