package com.atm.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.daoimpl.AtmMoneyManagementImpl;
import com.atm.daoimpl.TransActionsImpl;
import com.atm.daoimpl.UserProfileImpl;

import com.atm.exception.AtmOutOfCashException;
import com.atm.exception.LowBalanceException;
import com.atm.models.AtmMoneyManagementModel;
import com.atm.models.TransActionsModel;
import com.atm.models.UserProfileModel;

@WebServlet("/withdrawserv")
public class WithdrawController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		TransActionsModel transActionsModel = new TransActionsModel();
		TransActionsImpl transActionsImpl = new TransActionsImpl();
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
		HttpSession session = req.getSession();
		String userName = session.getAttribute("user").toString();
		int enteredAmount = (int) session.getAttribute("withamount");
		UserProfileModel userprofileModelGetAccno = new UserProfileModel(userName);
		Long accno;
		try {
			accno = userprofileimpl.getAccountNo(userprofileModelGetAccno);
			transActionsModel.setUserAccnoLong(accno);
			int withdrawSum = transActionsImpl.checkwithdrawlimit(transActionsModel);
			int withdrawCheck = 0;
			// amount should be less than 10000:
			if (enteredAmount <= 10000) {
				// withdraw sum should be less than 10000:
				withdrawCheck = enteredAmount + withdrawSum;
				if (withdrawCheck <= 10000) {
					// amount less than atm money:
					Long atmPreviousBalance = atmMoneyManagementimpl.atmPreviousBalance();
					if (enteredAmount <= atmPreviousBalance) {
						UserProfileModel userprofilemodel = new UserProfileModel(userName);
						int userBalance = userprofileimpl.getUserBalance(userprofilemodel);
						if (enteredAmount <= userBalance) {
							int newbal = userBalance - enteredAmount;
							UserProfileModel userprofileModelInsertBalance = new UserProfileModel(userName, newbal);
							userprofileimpl.insertUserBalance(userprofileModelInsertBalance);
							UserProfileModel userprofilemodel3 = new UserProfileModel(userName, newbal);
							Long acc = userprofileimpl.getAccountNo(userprofilemodel3);
							transActionsModel.setUserAccnoLong(acc);
							transActionsModel.setTransActionAmount(-enteredAmount);
							transActionsModel.setTransActionType("withdraw");
							transActionsImpl.insertTransAction(transActionsModel);
							session.setAttribute("withamount", enteredAmount);
							session.setAttribute("withbal", newbal);
							// Atm money management:
							Long dedbaL1 = atmMoneyManagementimpl.atmPreviousBalance()-enteredAmount;
							AtmMoneyManagementModel atmMoneyManagement = new AtmMoneyManagementModel(dedbaL1);
							atmMoneyManagementimpl.updateNewAtmBalance(atmMoneyManagement);
							res.sendRedirect("withdrawSuccess.jsp");
						} else {
							throw new LowBalanceException();
						}
					} else {
						throw new AtmOutOfCashException();
					}
				} else {
					int remainingWithdraw = (10000 - withdrawSum);
					if (remainingWithdraw > 0) {
						session.setAttribute("remainingWithdraw", remainingWithdraw);
						res.sendRedirect("withdrawRemainingAmount.jsp");
					} else {
						res.sendRedirect("withdrawLimitExceed.jsp");
					}
				}
			} else {
				res.sendRedirect("withdrawEnteredAmountExcceed.jsp");
			}
		} catch (AtmOutOfCashException e) {
			res.sendRedirect(e.getMessage());
		} catch (LowBalanceException e) {
			res.sendRedirect(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
