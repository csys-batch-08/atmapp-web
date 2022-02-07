package com.atm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.atm.service.AgentHistoryService;



@WebServlet("/agenthistoryservlet")
public class AgentHistoryController extends HttpServlet{
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
	try {
				req.setAttribute("agenthistoryobj", AgentHistoryService.showRefillHistory());
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("agentHistory.jsp");
				requestDispatcher.forward(req, resp);
			} catch (Exception e) {			
				e.getMessage();
			}	
}
}
