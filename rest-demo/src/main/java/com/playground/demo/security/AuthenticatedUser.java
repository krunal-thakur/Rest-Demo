package com.playground.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.playground.demo.common.model.User;

@Component
public class AuthenticatedUser {
	
	public User getAuthenticatedUser() {
		User user = null;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication != null) {
			Object principal = authentication.getPrincipal();
			
			// principal can be "anonymousUser" (String)
			if(principal instanceof UserDetails) {
				UserDetails userDetails = (UserDetails) principal;
				user = userDetails.getUser();
			}
		}
		return user;
	}
}
