package com.atm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.UserProfileModel;


@WebServlet("/pinchangeserv")
public class PinChangeController extends HttpServlet {	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pinChanged = -1;
		try {
		UserProfileImpl userProfileImpl = new UserProfileImpl();		
		int pin = Integer.parseInt(req.getParameter("pininp"));
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
			UserProfileModel userProfileModel = new UserProfileModel(pin,user);
			pinChanged = userProfileImpl.updateUserPin(userProfileModel);
		} catch (Exception e) {
			e.getMessage();
		}
		if (pinChanged > 0) {
			resp.sendRedirect("pinChangeSuccess.jsp");
		} else {
			resp.getWriter().println("Something went wrong try again!!!");
		}
	}

}
