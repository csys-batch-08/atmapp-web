package com.atm.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.TransActionsImpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.exception.DepositLimitExceedException;

import com.atm.models.TransActionsModel;
import com.atm.models.UserProfileModel;
import com.atm.service.DepositService;

@WebServlet("/depserv")
public class DepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		String uname = session.getAttribute("user").toString();
		int eamount = (int) session.getAttribute("depamount");
		
String status = DepositService.depositeMoney(uname, eamount);

if(status.equals("DepositLimitExceedException")){
throw new DepositLimitExceedException();
}

if(status.equals("invalidUser")){
res.sendRedirect("invalidUser.jsp");
}

if(status.equals("depositAmountRemaining")){

if(status.equals("depositAmountRemaining")){
session.setAttribute("remainingDeposit", remainingDeposit);
		res.sendRedirect("depositAmountRemaining.jsp");
}else if(status.equals("depositLimitExceed")){
res.sendRedirect("depositLimitExceed.jsp");
}
}

if(status.equals("depositEnteredLimit")){
throw new DepositLimitExceedException();
}

if(status.equals("depositeSucess")){
session.setAttribute("depsuccamount", eamount);
						session.setAttribute("depsuccbal", newbal);
						res.sendRedirect("depositsuccess.jsp");
}


	}
}
