package com.atm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.AtmMoneyManagementImpl;
import com.atm.models.AtmMoneyManagementModel;



@WebServlet("/depagentserv")
public class AtmMoneyManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		Long eamount = Long.parseLong(req.getParameter("depagentamount"));
		AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
		HttpSession session = req.getSession();
		String agent = session.getAttribute("agent").toString();	
			// fetch previous balance:
			long prevbal = atmMoneyManagementimpl.atmPreviousBalance();
//entered amount should be greater than 2000 and less than 50000:
			if (eamount >= 2000 && eamount <= 50000) {
				// previous balance should be less than 2000:
				if (prevbal <= 2000) {
					AtmMoneyManagementModel atmMoneyManagement = new AtmMoneyManagementModel(eamount + prevbal, agent);
						//insert record in table:
						atmMoneyManagementimpl.depositAtmMoney(atmMoneyManagement);
						//atm refill success:
							session.setAttribute("agentdepamount", eamount);
							resp.sendRedirect("atmMoneyManagementSuccess.jsp");	 
				} else {
					resp.sendRedirect("atmRefillNotNeeded.jsp");
				}
			} else {
				resp.getWriter().println("Enter Valid Amount!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
