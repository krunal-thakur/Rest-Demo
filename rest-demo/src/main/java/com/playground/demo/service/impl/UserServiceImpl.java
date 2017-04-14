 package com.playground.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.playground.demo.common.model.User;
import com.playground.demo.security.AuthenticatedUser;
import com.playground.demo.service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	private final static String USER_TEST = "root";
	private final AuthenticatedUser authenticatedUser;
	
	@Autowired
	public UserServiceImpl(AuthenticatedUser authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	

	@Override
	public User getUserByUsername(String username) {
		if(StringUtils.equalsIgnoreCase(username, USER_TEST)){
			User user = new User();
			user.setLogin(username);
			user.setPassword(new ShaPasswordEncoder(128).encodePassword("password", null));
			return user;
		}
		return null;
	}

	@Override
	public List<String> getPermissions(String username) {
		return new ArrayList<>();
	}

	@Override
	public User getCurrentUser() {
		return authenticatedUser.getAuthenticatedUser();
	}

	@Override
	public Boolean isCurrentUserLoggedIn() {
		return authenticatedUser.getAuthenticatedUser() != null;
	}

}
