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
import com.atm.logger.Logger;
import com.atm.models.UserProfileModel;

@WebServlet("/allUserDetailsServlet")
public class AllUserDetailsController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
UserProfileImpl userProfileImpl = new UserProfileImpl();
try {
	List<UserProfileModel> userProfileModels = userProfileImpl.fetchUserDetails();
	req.setAttribute("allUserDetailsList", userProfileModels);
	RequestDispatcher requestDispatcher = req.getRequestDispatcher("allUserDetails.jsp");
	requestDispatcher.forward(req, resp);
} catch (SQLException e) {
	Logger.printStackTrace(e);
	Logger.runTimeException(e.getMessage());
} 
		
	}
}
