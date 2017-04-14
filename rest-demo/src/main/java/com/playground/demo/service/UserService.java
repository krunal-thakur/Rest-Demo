package com.playground.demo.service;

import java.util.List;

import com.playground.demo.common.model.User;

public interface UserService {
	User getUserByUsername(String username);

    List<String> getPermissions(String username);

    User getCurrentUser();

    Boolean isCurrentUserLoggedIn();
}
