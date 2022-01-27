package com.atm.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.TransActionsImpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.exception.DepositLimitExceedException;

import com.atm.models.TransActionsModel;
import com.atm.models.UserProfileModel;


@WebServlet("/depserv")
public class DepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		TransActionsModel transActionsModel = new TransActionsModel();
		TransActionsImpl transActionsImpl = new TransActionsImpl();
		HttpSession session = req.getSession();
		String uname = session.getAttribute("user").toString();
		int eamount = (int) session.getAttribute("depamount");
		UserProfileModel userprofilemodelaccno = new UserProfileModel(uname);
		Long accno;
		try {
//get acc no:
			accno = userprofileimpl.getaccno(userprofilemodelaccno);
			transActionsModel.setUserAccnoLong(accno);
			//check withdraw limit:
			int depositSum = transActionsImpl.checkDepositLimit(transActionsModel);
			int depositCheck = 0;
			// amount should be less than 20000:
			if (eamount <= 20000) {
				// deposit sum should be less than 20000:
				depositCheck = eamount + depositSum;
				if (depositCheck <= 20000) {
					UserProfileModel userprofilemodel = new UserProfileModel(uname);
					// get user balance:
					if (userprofileimpl.getbal(userprofilemodel) >= 0) {
						int bal = userprofileimpl.getbal(userprofilemodel);
						// Amount greater than 0 and less than 20000:
						if (eamount > 0 && eamount < 20000) {
							int newbal = bal + eamount;
							UserProfileModel userprofilemodel2 = new UserProfileModel(uname, newbal);
							// update New Balance:
							userprofileimpl.insbal(userprofilemodel2);
								// Get User Account Number:
								UserProfileModel userprofilemodel3 = new UserProfileModel(uname);
								Long acc = userprofileimpl.getaccno(userprofilemodel3);
									// Insert data in Deposit table:
									transActionsModel.setUserAccnoLong(acc);
									transActionsModel.setTransActionAmount(eamount);
									transActionsModel.setTransActionType("deposit");
									transActionsImpl.insertTransAction(transActionsModel);
									session.setAttribute("depsuccamount", eamount);
									session.setAttribute("depsuccbal", newbal);
									res.sendRedirect("Depsucc.jsp");
						} else {
							throw new DepositLimitExceedException();
						}
					} else {
						res.sendRedirect("Invaliduser.jsp");
					}
				} else {
					int remainingDeposit = (20000 - depositSum);
					if (remainingDeposit > 0) {
						session.setAttribute("remainingDeposit", remainingDeposit);
						res.sendRedirect("DepositAmountRemaining.jsp");
					} else {
						res.sendRedirect("DepositLimitExceed.jsp");
					}
				}
			} else {
				res.sendRedirect("DepositEnteredLimit.jsp");
			}
		} catch (DepositLimitExceedException e) {
			res.sendRedirect(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
