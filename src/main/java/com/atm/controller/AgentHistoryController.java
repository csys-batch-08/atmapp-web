package com.atm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.atm.daoimpl.AtmMoneyManagementImpl;
import com.atm.models.AtmMoneyManagementModel;



@WebServlet("/agenthistoryservlet")
public class AgentHistoryController extends HttpServlet{
	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
	try {
	AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
				List<AtmMoneyManagementModel> atmMoneyManagementModels = atmMoneyManagementimpl.showRefillHistory();
				req.setAttribute("agenthistoryobj", atmMoneyManagementModels);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("agentHistory.jsp");
				requestDispatcher.forward(req, resp);
			} catch (Exception e) {			
				e.printStackTrace();
			}	
}
}
