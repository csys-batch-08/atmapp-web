package com.atm.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.atm.daoimpl.TransActionsImpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.exception.DepositLimitExceedException;
import com.atm.models.TransActionsModel;
import com.atm.models.UserProfileModel;

public class DepositService {

	
	
public static String depositeMoney(String uname,int eamount) {
	try {
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		TransActionsModel transActionsModel = new TransActionsModel();
		TransActionsImpl transActionsImpl = new TransActionsImpl();
		
		UserProfileModel userprofilemodelaccno = new UserProfileModel(uname);
		Long accno;
		// get acc no:s
		accno = userprofileimpl.getAccountNo(userprofilemodelaccno);
		transActionsModel.setUserAccnoLong(accno);
		// check withdraw limit:
		int depositSum = transActionsImpl.checkDepositLimit(transActionsModel);
		int depositCheck = 0;
		// amount should be less than 20000:
		if (eamount <= 20000) {
			// deposit sum should be less than 20000:
			depositCheck = eamount + depositSum;
			if (depositCheck <= 20000) {
				UserProfileModel userprofilemodel = new UserProfileModel(uname);
				// get user balance:
				if (userprofileimpl.getUserBalance(userprofilemodel) >= 0) {
					int bal = userprofileimpl.getUserBalance(userprofilemodel);
					// Amount greater than 0 and less than 20000:
					if (eamount > 0 && eamount < 20000) {
						int newbal = bal + eamount;
						UserProfileModel userprofilemodel2 = new UserProfileModel(uname, newbal);
						// update New Balance:
						userprofileimpl.insertUserBalance(userprofilemodel2);
						// Get User Account Number:
						UserProfileModel userprofilemodel3 = new UserProfileModel(uname);
						Long acc = userprofileimpl.getAccountNo(userprofilemodel3);
						// Insert data in Deposit table:
						transActionsModel.setUserAccnoLong(acc);
						transActionsModel.setTransActionAmount(eamount);
						transActionsModel.setTransActionType("CREDIT");
						transActionsImpl.insertTransAction(transActionsModel);
						return "depositeSucess";
					} else {
						return "DepositLimitExceedException";
					}
				} else {
					return "invalidUser";
				}
			} else {
				
				return depositLimitCheck(transActionsModel);
			}
		} else {
			return "depositEnteredLimit";
		}
	} catch (DepositLimitExceedException e) {
		res.sendRedirect(e.getMessage());
	} catch (Exception e) {
		e.getMessage();
	}
}
public static String depositLimitCheck(TransActionsModel transActionsModel) {
	UserProfileImpl userprofileimpl = new UserProfileImpl();
	TransActionsImpl transActionsImpl = new TransActionsImpl();
	int depositSum = 0;
	try {
		depositSum = transActionsImpl.checkDepositLimit(transActionsModel);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	int remainingDeposit = (20000 - depositSum);
	if (remainingDeposit > 0) {
		return "depositAmountRemaining";
	} 
	return "depositLimitExceed";
}
}
