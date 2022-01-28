package com.atm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.UserProfileModel;



@WebServlet("/balanceservlet")
public class BalanceController extends HttpServlet{
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String user = session.getAttribute("user").toString();
	UserProfileImpl userProfiledao = new UserProfileImpl();
	UserProfileModel userprofilepojo = new UserProfileModel(user);
	try {
		int balance = userProfiledao.getUserBalance(userprofilepojo);
		req.setAttribute("balanceInt", balance);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("balance.jsp");
		requestDispatcher.forward(req, resp);
	} catch (Exception e) {

		e.printStackTrace();
	}
}
}
