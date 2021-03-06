package com.atm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.logger.Logger;
import com.atm.models.UserProfileModel;


@WebServlet("/pinchangeserv")
public class PinChangeController extends HttpServlet {	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		int pinChanged = -1;
		try {
		UserProfileImpl userProfileImpl = new UserProfileImpl();		
		int pin = Integer.parseInt(req.getParameter("pininp"));
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
			UserProfileModel userProfileModel = new UserProfileModel(pin,user);
			pinChanged = userProfileImpl.updateUserPin(userProfileModel);
			if (pinChanged > 0) {
				resp.sendRedirect("pinChangeSuccess.jsp");
			} else {
				resp.getWriter().println("Something went wrong try again!!!");
			}
		} catch (SQLException | NumberFormatException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} 
		
	}

}
