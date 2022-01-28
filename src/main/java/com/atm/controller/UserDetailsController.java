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
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.UserProfileModel;


@WebServlet("/userdetailsservletuser")
public class UserDetailsController extends HttpServlet{
	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String userName = session.getAttribute("user").toString();
	UserProfileModel userprofilepojo = new UserProfileModel(userName);
	UserProfileImpl userProfileImpl = new UserProfileImpl();
	try {
		List<UserProfileModel> userProfileModels = userProfileImpl.fetchUserDetails(userprofilepojo);
		req.setAttribute("userprofilelistobjuser", userProfileModels);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("userDetails.jsp");
		requestDispatcher.forward(req, resp);		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
