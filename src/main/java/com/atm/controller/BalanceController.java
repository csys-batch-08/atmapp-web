package com.atm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.atm.service.BalanceService;



@WebServlet("/balanceservlet")
public class BalanceController extends HttpServlet{
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
	HttpSession session = req.getSession();
	String user = session.getAttribute("user").toString();
	
		req.setAttribute("balanceInt", BalanceService.getUserBalance(user));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("balance.jsp");
		requestDispatcher.forward(req, resp);
	} catch (Exception e) {
         e.getMessage();
	}
}
}
