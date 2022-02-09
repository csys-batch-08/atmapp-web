package com.atm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.exception.InvalidUsernameAdminException;
import com.atm.logger.Logger;
import com.atm.models.UserProfileModel;



@WebServlet("/userdetailsservletadmin")
public class UserDetailsAdminController extends HttpServlet{
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String username = req.getParameter("userdetadmin");
	UserProfileModel userprofilepojo = new UserProfileModel(username);
	UserProfileImpl userProfileImpl = new UserProfileImpl();
	try {
		List<UserProfileModel> userProfileModels = userProfileImpl.fetchUserDetails(userprofilepojo);
		if(userProfileModels.isEmpty()) {
			throw new InvalidUsernameAdminException();
		}
		req.setAttribute("userdetailslistobj", userProfileModels);
		RequestDispatcher rsDispatcher = req.getRequestDispatcher("userDetailAdmin.jsp");
		rsDispatcher.forward(req, resp);
	} catch (SQLException | IOException e) {
		e.getMessage();
	}catch(InvalidUsernameAdminException e){
		try {
			resp.sendRedirect(e.getMessage());
		} catch (IOException e2) {
	Logger.printStackTrace(e2);
	Logger.runTimeException(e2.getMessage());
		}
		}
}
}

