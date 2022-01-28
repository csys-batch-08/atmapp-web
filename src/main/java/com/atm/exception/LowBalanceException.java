package com.atm.exception;

public class LowBalanceException extends Exception{
@Override
public String getMessage() {
	return "lowBalance.jsp";
}
}
