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
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String user = session.getAttribute("user").toString();
	int pin = Integer.parseInt(req.getParameter("minipin"));
	UserProfileImpl userprofileimpl = new UserProfileImpl();
	InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl(); 
	try {
		int userpin = userprofileimpl.getUserPin(user);
		if (userpin > 0) {
			if (userpin == pin) {
				res.sendRedirect("minisateserv");
			} else {
				int invalid = (int)session.getAttribute("invalidpinlock");
				invalid++;
				if(invalid < 3) {
					session.removeAttribute("invalidpinlock");
				session.setAttribute("invalidpinlock", invalid);
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
		e.printStackTrace();
	}
}
}
