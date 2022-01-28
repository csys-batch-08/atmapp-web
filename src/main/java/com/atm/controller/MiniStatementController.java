package com.atm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.MiniStatementImpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.TransActionsModel;
import com.atm.models.UserProfileModel;



@WebServlet("/minisateserv")

public class MiniStatementController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String user = null;
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			resp.sendRedirect("index.jsp");
		} else {
			user = session.getAttribute("user").toString();
		}
		UserProfileImpl userProfileImpl = new UserProfileImpl();
		UserProfileModel userprofilepojo = new UserProfileModel(user);
			Long accno = userProfileImpl.getAccountNo(userprofilepojo);
			MiniStatementImpl miniStatementImpl = new MiniStatementImpl();
			List<TransActionsModel> ministatementobj = miniStatementImpl.fetchMiniStatement(accno);
			req.setAttribute("ministatementjspobj", ministatementobj);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("miniStatement.jsp");
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
}
