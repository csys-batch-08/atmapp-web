package com.atm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.exception.InvalidUsernameAdminException;
import com.atm.models.UserProfileModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userdetailsservletadmin")
public class UserDetailsAdminController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String username = req.getParameter("userdetadmin");
	UserProfileModel userprofilepojo = new UserProfileModel(username);
	UserProfileImpl userProfileImpl = new UserProfileImpl();
	try {
		List<UserProfileModel> userProfileModels = userProfileImpl.getuserdetails(userprofilepojo);
		System.out.println(userProfileModels);
		if(userProfileModels.isEmpty()) {
			throw new InvalidUsernameAdminException();
		}
		req.setAttribute("userdetailslistobj", userProfileModels);
		RequestDispatcher rsDispatcher = req.getRequestDispatcher("Userdetailadmin.jsp");
		rsDispatcher.forward(req, resp);
	} catch (SQLException e) {
		e.printStackTrace();
	}catch(InvalidUsernameAdminException e){
		resp.sendRedirect(e.getMessage());
		}
}
}

