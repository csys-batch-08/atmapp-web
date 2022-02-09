package com.atm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atm.daoimpl.RemovedUsersImpl;
import com.atm.logger.Logger;
import com.atm.models.RemovedUsersModel;


@WebServlet("/Removeduserlistservlet")
public class RemovedusersController extends HttpServlet{
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	RemovedUsersImpl removedusersdao = new RemovedUsersImpl();
	try {
		List<RemovedUsersModel> removedUsersModels = removedusersdao.fetchRemovedUsers();
		req.setAttribute("removeduserslist", removedUsersModels);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("removedUsers.jsp");
		requestDispatcher.forward(req, resp);
	} catch (SQLException | IOException e) {
	
	Logger.printStackTrace(e);
	Logger.runTimeException(e.getMessage());
		
	}
}
}
