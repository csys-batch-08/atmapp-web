package com.atm.service;

import java.sql.SQLException;
import java.util.List;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.UserProfileModel;

public class AllUserDetailsService {
	
	private AllUserDetailsService() {
		
	}
	
	public static List<UserProfileModel> fetchUserDetails(){
	UserProfileImpl userProfileImpl = new UserProfileImpl();
	List<UserProfileModel> userProfileModels = null;
	try {
		userProfileModels = userProfileImpl.fetchUserDetails();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return userProfileModels;
	}
}
