package com.atm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.InvalidPinLockDaoimpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.InvalidPinLockModel;

@WebServlet("/Enterpinmoneytransfserv")
public class EnterPinMoneyTransfController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
		HttpSession session = req.getSession();
		String userMoneyTransfer = session.getAttribute("user").toString();
		int pinMoneyTransfer = Integer.parseInt(req.getParameter("moneytransfpin"));
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl(); 
		String invalidPinLockString = "invalidpinlock";
			int userpinMoneyTransfer = userprofileimpl.getUserPin(userMoneyTransfer);
			if (userpinMoneyTransfer > 0) {
				if (userpinMoneyTransfer == pinMoneyTransfer) {
					res.sendRedirect("moneyTransfer.jsp");
				} else {
					int countMoneyTransfer = (int)session.getAttribute(invalidPinLockString);
					countMoneyTransfer++;
					if(countMoneyTransfer < 3) {
						session.removeAttribute(invalidPinLockString);
					session.setAttribute(invalidPinLockString, countMoneyTransfer);
					session.setAttribute("invalidhomepin", true);
					res.sendRedirect("welcomePage.jsp");
					}else {
						InvalidPinLockModel invalidPinLockModel = new InvalidPinLockModel(userMoneyTransfer);
						invalidPinLockDaoimpl.insertInavalidPinLock(invalidPinLockModel);
						res.sendRedirect("invalidPinMax.jsp");
					}
				}
			}
		} 
		
		catch (Exception e) {

			e.getMessage();
		}
	}
}
