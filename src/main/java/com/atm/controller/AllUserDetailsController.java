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
import com.atm.service.AllUserDetailsService;

@WebServlet("/allUserDetailsServlet")
public class AllUserDetailsController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

try {

	req.setAttribute("allUserDetailsList", AllUserDetailsService.fetchUserDetails());
	RequestDispatcher requestDispatcher = req.getRequestDispatcher("allUserDetails.jsp");
	requestDispatcher.forward(req, resp);
} catch (IOException e) {
	Logger.printStackTrace(e);
	Logger.runTimeException(e.getMessage());
} 
		
	}
}
