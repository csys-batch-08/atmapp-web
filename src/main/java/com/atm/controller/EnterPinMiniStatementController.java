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


@WebServlet("/Enterpinminiserv")
public class EnterPinMiniStatementController extends HttpServlet{
	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	try {
	HttpSession session = req.getSession();
	String user = session.getAttribute("user").toString();
	int pin = Integer.parseInt(req.getParameter("minipin"));
	UserProfileImpl userprofileimpl = new UserProfileImpl();
	InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl();
	String invalidPinLockString = "invalidpinlock";
		int userpinMiniStatement = userprofileimpl.getUserPin(user);
		if (userpinMiniStatement > 0) {
			if (userpinMiniStatement == pin) {
				res.sendRedirect("minisateserv");
			} else {
				int countMiniStatement = (int)session.getAttribute(invalidPinLockString);
				countMiniStatement++;
				if(countMiniStatement < 3) {
					session.removeAttribute(invalidPinLockString);
				session.setAttribute(invalidPinLockString, countMiniStatement);
				session.setAttribute("invalidhomepin", true);
				res.sendRedirect("welcomePage.jsp");
				}else {
					InvalidPinLockModel invalidPinLockModel = new InvalidPinLockModel(user);
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
