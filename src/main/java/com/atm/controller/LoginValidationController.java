package com.atm.controller;



import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.InvalidPinLockDaoimpl;
import com.atm.daoimpl.LoginDetailsImpl;
import com.atm.daoimpl.UsernamePasswordImpl;
import com.atm.exception.InvalidEntriesException;
import com.atm.models.*;


@WebServlet("/loginval")
public class LoginValidationController extends HttpServlet {
private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		boolean flag = false;
		try {
		String userName = request.getParameter("username");
		String passwordParameter = request.getParameter("password");
		UsernamePasswordImpl userimpl = new UsernamePasswordImpl();
		LoginDetailsImpl logindetailsimpl = new LoginDetailsImpl();
		HttpSession session = request.getSession();
		InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl();
		InvalidPinLockModel invalidPinLockModel = new InvalidPinLockModel(userName);
			UsernamePasswordModel usernamepassmodel = new UsernamePasswordModel(userName, passwordParameter);
			String role = userimpl.fetchRole(usernamepassmodel);
			//check if user:
			if (role != null) {
				if (role.equals("user")) {
					//check the user in invalid pin lock table:
					if(!(invalidPinLockDaoimpl.invalidPinLockStatus(invalidPinLockModel))) {
					if(session.getAttribute("invalidpinlock") == null) {						
						session.setAttribute("invalidpinlock", 0);
					}
					LoginDetailsModel loginmodel = new LoginDetailsModel(userName, role);
					logindetailsimpl.insertLoginDetails(loginmodel);
					flag = true;
					session.setAttribute("user", userName);
					response.sendRedirect("welcomePage.jsp");
				}else {
					//fetch minutes:
					int retriveat = invalidPinLockDaoimpl.accountLockReleaseAt(invalidPinLockModel);
					if(retriveat > 2) {
						invalidPinLockDaoimpl.deleteInvalidPinLock(invalidPinLockModel);
						if(session.getAttribute("invalidpinlock") == null) {
							session.setAttribute("invalidpinlock", 0);
						}
						LoginDetailsModel loginmodel = new LoginDetailsModel(userName, role);
						logindetailsimpl.insertLoginDetails(loginmodel);
						flag = true;
						session.setAttribute("user", userName);
						response.sendRedirect("welcomePage.jsp");
					}else {
						flag = true;
						response.sendRedirect("invalidPinMax.jsp");
					}
				}
				}
				else if (role.equals("admin")) {
					LoginDetailsModel loginmodel = new LoginDetailsModel(userName, role);
					logindetailsimpl.insertLoginDetails(loginmodel);
					flag = true;
					session.setAttribute("admin", userName);
					response.sendRedirect("admin.jsp");
				}else if(role.equals("agent")) {
					LoginDetailsModel loginmodel = new LoginDetailsModel(userName, role);
					logindetailsimpl.insertLoginDetails(loginmodel);
					flag = true;
					session.setAttribute("agent", userName);
					response.sendRedirect("agent.jsp");
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		// invalid user redirect:
try {
		if (!flag) {
			throw new InvalidEntriesException();
		}
}catch(InvalidEntriesException e) {
	String red = e.getMessage();
	try {
		response.sendRedirect(red);
	} catch (IOException e1) {
		e1.getMessage();
	}
}
	}

}
