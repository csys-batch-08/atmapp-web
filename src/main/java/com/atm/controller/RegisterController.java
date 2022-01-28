package com.atm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.models.UsernamePasswordModel;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.daoimpl.UsernamePasswordImpl;
import com.atm.exception.MobileNoAlreadyRegException;
import com.atm.exception.UserNameAlreadyExistException;
import com.atm.models.UserProfileModel;


@WebServlet("/registersucc")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsernamePasswordImpl userimpl = new UsernamePasswordImpl();
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		Long accno = 0l;
		int userpin = 0;
		try {
			if (userprofileimpl.getUserMaximumAccountNo() > 0 && userprofileimpl.getUserMaximumPin() > 0) {
				accno = userprofileimpl.getUserMaximumAccountNo() + 1;
				userpin = userprofileimpl.getUserMaximumPin() + 1;
			} else {
				accno = 12345678901l;
				userpin = 1234;
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String username = req.getParameter("userreg");
		String password = req.getParameter("passreg");
		String role = req.getParameter("rolereg");
		Long mobno = Long.parseLong(req.getParameter("mobnoreg"));
		UserProfileModel userProfileModel = new UserProfileModel(mobno, "s");
		UserProfileImpl userProfileImpl2 = new UserProfileImpl();
		boolean flag = false;
		try {
			flag = userProfileImpl2.userMobileNoExistCheck(userProfileModel);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			if (!flag) {
				UsernamePasswordModel usernamepassmodel = new UsernamePasswordModel(username, password, role);
				int ins = userimpl.insertUsernamePasswords(usernamepassmodel);
				if (ins > 0) {
					if (role.equals("admin")) {
						HttpSession session = req.getSession();
						session.setAttribute("adminreg", username);
						resp.sendRedirect("adminRegisterSuccess.jsp");
					} else if (role.equals("agent")) {
						HttpSession session = req.getSession();
						session.setAttribute("agentreg", username);
						resp.sendRedirect("agentRegisterSuccess.jsp");
					} else {
						UserProfileModel userprofilemodel = new UserProfileModel(username, accno, mobno, userpin);
						int profins = userprofileimpl.insertUserProfile(userprofilemodel);
						if (profins > 0) {
							HttpSession session = req.getSession();
							session.setAttribute("reguser", username);
							resp.sendRedirect("registerUserProfileSuccess.jsp");
						} else {
							throw new MobileNoAlreadyRegException();
						}
					}
				} else {
					throw new UserNameAlreadyExistException();
				}
			} else {
				throw new MobileNoAlreadyRegException();
			}
		} catch (UserNameAlreadyExistException e) {
			resp.sendRedirect(e.getMessage());
		} catch (MobileNoAlreadyRegException e) {
			resp.sendRedirect(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}