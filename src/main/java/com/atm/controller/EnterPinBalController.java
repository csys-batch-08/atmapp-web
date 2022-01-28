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


@WebServlet("/enterpinbalserv")
public class EnterPinBalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
		int pin = Integer.parseInt(req.getParameter("balpin"));
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl();
			// fetch user pin from table:
			int userpin = userprofileimpl.getUserPin(user);
			if (userpin > 0) {
				if (userpin == pin) {
					res.sendRedirect("balanceservlet");
				} else {
					// invalid pin section:
					int invalid = (int) session.getAttribute("invalidpinlock");
					invalid++;
					if (invalid < 3) {
						session.removeAttribute("invalidpinlock");
						session.setAttribute("invalidpinlock", invalid);
						session.setAttribute("invalidhomepin", true);
						res.sendRedirect("welcomePage.jsp");
					} else {
						// invalid pin entry more than three time:
						InvalidPinLockModel invalidPinLockModel = new InvalidPinLockModel(user);
						// insert data in invalidpinlock table:
						invalidPinLockDaoimpl.insertInavalidPinLock(invalidPinLockModel);
						res.sendRedirect("invalidPinMax.jsp");
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
