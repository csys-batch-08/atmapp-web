package com.atm.controller;

import com.atm.daoimpl.*;
import com.atm.models.TransActionsModel;
import com.atm.models.UserProfileModel;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/moneytransferserv")
public class MoneyTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String username = req.getParameter("moneytransfname");
		Long accountno = Long.parseLong(req.getParameter("moneytransfaccno"));
		int eamount = Integer.parseInt(req.getParameter("moneytransfamount"));
		TransActionsModel transActionsModel = new TransActionsModel();
		TransActionsImpl transActionsImpl = new TransActionsImpl();
		UserProfileModel userprofilemodel = new UserProfileModel(username, accountno);
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
			// fetch sender balance:
			int bal = userprofileimpl.moneyTransfer(userprofilemodel);
			if (bal >= 0) {
				UserProfileModel userprofileModelGetBalance = new UserProfileModel(user);
				int userbal = userprofileimpl.getUserBalance(userprofileModelGetBalance);
				if (eamount <= userbal && eamount > 0 && eamount <= 30000) {
					int withamount = userbal - eamount;
					UserProfileModel userprofileModelInsertBalance = new UserProfileModel(user, withamount);
					userprofileimpl.insertUserBalance(userprofileModelInsertBalance);
					Long useraccountno = userprofileimpl.getAccountNo(userprofileModelGetBalance);
					transActionsModel.setUserAccnoLong(useraccountno);
					transActionsModel.setTransActionAmount(-eamount);
					transActionsModel.setTransActionType("withdraw");
					transActionsModel.setMoneyTransfer("Money Transfer To " + username);
					transActionsImpl.insertTransAction(transActionsModel);
					// fetch receiver balance:
					UserProfileModel userprofileModelReceiverBalance = new UserProfileModel(username);
					int userDepositBalance = userprofileimpl.getUserBalance(userprofileModelReceiverBalance);
					// add received amount:
					int depositAmount = userDepositBalance + eamount;
					UserProfileModel userprofileModelReceivedAmount = new UserProfileModel(username, depositAmount);
					 userprofileimpl.insertUserBalance(userprofileModelReceivedAmount);
						transActionsModel.setUserAccnoLong(accountno);
						transActionsModel.setTransActionAmount(eamount);
						transActionsModel.setTransActionType("deposit");
						transActionsModel.setMoneyTransfer("Money Transfer From " + user);
						int insertDepositUser = transActionsImpl.insertTransAction(transActionsModel);
						if (insertDepositUser > 0) {
							session.setAttribute("moneytransfname", username);
							session.setAttribute("moneytransfamount", eamount);
							UserProfileModel userprofilepojo = new UserProfileModel(user);
							UserProfileImpl userprofiledao = new UserProfileImpl();
							int userNewBalance = userprofiledao.getUserBalance(userprofilepojo);
							session.setAttribute("userbalint", userNewBalance);
							resp.sendRedirect("moneyTransfersuccess.jsp");
						}
				} else {
					resp.getWriter().println("Enter Valid Amount!!!");
				}
			} else {
				resp.getWriter().println("Invalid Username or Password!!!");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}