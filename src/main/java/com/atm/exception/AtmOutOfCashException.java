package com.atm.exception;

public class AtmOutOfCashException extends Exception{
	private static final long serialVersionUID = 1L;

@Override
public String getMessage() {
	return "atmOutOfCash.jsp";
}
}
