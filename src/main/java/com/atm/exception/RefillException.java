package com.atm.exception;

public class RefillException extends Exception{
	private static final long serialVersionUID = 1L;

@Override
public String getMessage() {

	return "atmRefillNotNeeded.jsp";
}
}