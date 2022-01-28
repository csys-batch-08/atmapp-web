package com.atm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atm.daoimpl.LoginDetailsImpl;
import com.atm.models.LoginDetailsModel;


@WebServlet("/logindetailsservlet")
public class LoginDetailsController extends HttpServlet{

	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
	LoginDetailsImpl logindetailsdao = new LoginDetailsImpl();
			List<LoginDetailsModel> loginDetailsModels = logindetailsdao.fetchLoginDetails();
			req.setAttribute("logindetailsobj", loginDetailsModels);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginDetails.jsp");
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			e.getMessage();
		}
	
}
}
