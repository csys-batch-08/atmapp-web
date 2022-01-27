package com.atm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atm.daoimpl.LoginDetailsImpl;
import com.atm.daoimpl.RemovedUsersImpl;
import com.atm.daoimpl.TransActionsImpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.daoimpl.UsernamePasswordImpl;
import com.atm.exception.InvalidUsernameAdminException;
import com.atm.models.DepositModel;
import com.atm.models.LoginDetailsModel;
import com.atm.models.RemovedUsersModel;
import com.atm.models.TransActionsModel;
import com.atm.models.UsernamePasswordModel;
import com.atm.models.UserProfileModel;


@WebServlet("/removeaccserv")
public class RemoveUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginDetailsImpl loginDetailsimpl = new LoginDetailsImpl();
		TransActionsImpl transActionsImpl = new TransActionsImpl();
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		RemovedUsersImpl removedUsersimpl = new RemovedUsersImpl();
		UsernamePasswordImpl userimpl = new UsernamePasswordImpl();
		String user = req.getParameter("remusername");
		int id = Integer.parseInt(req.getParameter("remuserid"));
		Long accno = -1l;
		try {
			UserProfileModel userprofilemodel = new UserProfileModel(user);
			accno = userprofileimpl.getaccno(userprofilemodel);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			LoginDetailsModel loginModel = new LoginDetailsModel(user);
			int loginRemove = loginDetailsimpl.removeLoginDetails(loginModel);
			if (loginRemove >= 0) {
				TransActionsModel transActionsModel = new TransActionsModel();
				transActionsModel.setUserAccnoLong(accno);
				int transactionRemove = transActionsImpl.removeTransActions(transActionsModel);
				if (transactionRemove >= 0) {					
						UserProfileModel userprofilemodel = new UserProfileModel(user);
						List<UserProfileModel> userProfileModels = userprofileimpl.getuserdetails(userprofilemodel);						
							int lastbalance = userProfileModels.get(0).getBalance();
							Long mobno = userProfileModels.get(0).getMobno();
							int userpin = userProfileModels.get(0).getUserpin();
							RemovedUsersModel removedUsersModel = new RemovedUsersModel(accno, user, lastbalance, mobno,
									userpin);
							removedUsersimpl.insertRemovedUsers(removedUsersModel);						
					UserProfileModel userprofileModelRemoveUserProfile = new UserProfileModel(accno, id);
					int userprofrem = userprofileimpl.removeuserprof(userprofileModelRemoveUserProfile);
					if (userprofrem > 0) {
						UsernamePasswordModel usernamepassmodel = new UsernamePasswordModel(user);
						int userrem = userimpl.removeuser(usernamepassmodel);
						if (userrem > 0) {
							resp.sendRedirect("Userrem.jsp");
						} else {
							resp.getWriter().println("Invalid UserName");
						}
					} else {
						UsernamePasswordModel usernamepassmodel = new UsernamePasswordModel(user);
						int userrem = userimpl.removeuser(usernamepassmodel);
						if (userrem > 0) {
							resp.sendRedirect("Userrem.jsp");
						} else {
							throw new InvalidUsernameAdminException();
						}
					}
				}
			}

		} catch (InvalidUsernameAdminException e) {
			resp.sendRedirect(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
