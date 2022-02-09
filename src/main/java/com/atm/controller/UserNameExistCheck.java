package com.atm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.UserProfileModel;

@WebServlet("/userNameExistCheckServlet")
public class UserNameExistCheck extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String userName =req.getParameter("userName"); 
	
	
	 try {
		 UserProfileModel userProfileModel = new UserProfileModel(userName);
		 UserProfileImpl userProfileImpl = new UserProfileImpl();
		long user;
	
			user = userProfileImpl.getAccountNo(userProfileModel);
		 System.out.println(user);
		if(user!=-1) {
			res.getWriter().print("Username Already Registered");
		}
		
}catch (SQLException e) {
	e.printStackTrace();
}
}
}
