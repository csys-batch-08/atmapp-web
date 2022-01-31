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
import com.atm.exception.DepositWrongPinException;
import com.atm.models.InvalidPinLockModel;


@WebServlet("/Enterpindepservlet")
public class EnterPinDepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
		int pin = Integer.parseInt(req.getParameter("deppin"));
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl();
		String invalidPinLockString = "invalidpinlock";
			int userpinDeposit = userprofileimpl.getUserPin(user);
			if (userpinDeposit > 0) {
				if (userpinDeposit == pin) {
					res.sendRedirect("depserv");
				}  else {
					int countDeposit = (int)session.getAttribute(invalidPinLockString);
					countDeposit++;
					if(countDeposit < 3) {
						session.removeAttribute(invalidPinLockString);
					session.setAttribute(invalidPinLockString, countDeposit);
					session.setAttribute("invaliddeppin", true);
					throw new DepositWrongPinException();
					}else {
						InvalidPinLockModel invalidPinLockModel = new InvalidPinLockModel(user);
						invalidPinLockDaoimpl.insertInavalidPinLock(invalidPinLockModel);
						res.sendRedirect("invalidPinMax.jsp");
					}
				}
			}
		} catch(DepositWrongPinException e) {
			res.sendRedirect(e.getMessage());
		}	
		catch (Exception e) {
        e.getMessage();
		}
	}
}
