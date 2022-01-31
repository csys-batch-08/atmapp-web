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
import com.atm.exception.WithdrawWrongPinException;
import com.atm.models.InvalidPinLockModel;

@WebServlet("/Enterpinservlet")
public class EnterpinWithdrawController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
		HttpSession session = req.getSession();
		String userWithdraw = session.getAttribute("user").toString();
		int pinWithdraw = Integer.parseInt(req.getParameter("withpin"));
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl();
		String invalidPinLockString = "invalidpinlock";
			int userpinWithdraw = userprofileimpl.getUserPin(userWithdraw);
			if (userpinWithdraw > 0) {
				if (userpinWithdraw == pinWithdraw) {
					res.sendRedirect("withdrawserv");
				} else {
					int countWithdraw = (int)session.getAttribute(invalidPinLockString);
					countWithdraw++;
					if(countWithdraw < 3) {
						session.removeAttribute(invalidPinLockString);
					session.setAttribute(invalidPinLockString, countWithdraw);
					session.setAttribute("invalidpin", true);
					throw new WithdrawWrongPinException();
					}else {
						InvalidPinLockModel invalidPinLockModel = new InvalidPinLockModel(userWithdraw);
						invalidPinLockDaoimpl.insertInavalidPinLock(invalidPinLockModel);
						res.sendRedirect("invalidPinMax.jsp");
					}
				}
			}
		} catch(WithdrawWrongPinException e) {
			res.sendRedirect(e.getMessage());
		}
		
		catch (Exception e) {
			e.getMessage();
		}
	}
}
