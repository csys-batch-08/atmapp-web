package com.atm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.atm.daoimpl.RemovedUsersImpl;
import com.atm.models.RemovedUsersModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Removeduserlistservlet")
public class RemovedusersController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	RemovedUsersImpl removedusersdao = new RemovedUsersImpl();
	try {
		List<RemovedUsersModel> removedUsersModels = removedusersdao.fetchremoveusers();
		req.setAttribute("removeduserslist", removedUsersModels);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Removedusers.jsp");
		requestDispatcher.forward(req, resp);
	} catch (SQLException e) {

		e.printStackTrace();
	}
}
}
