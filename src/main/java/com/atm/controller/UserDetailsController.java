package com.atm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.UserProfileModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userdetailsservletuser")
public class UserDetailsController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String userName = session.getAttribute("user").toString();
	UserProfileModel userprofilepojo = new UserProfileModel(userName);
	UserProfileImpl userProfileImpl = new UserProfileImpl();
	try {
		List<UserProfileModel> userProfileModels = userProfileImpl.getuserdetails(userprofilepojo);
		req.setAttribute("userprofilelistobjuser", userProfileModels);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Userdetails.jsp");
		requestDispatcher.forward(req, resp);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
