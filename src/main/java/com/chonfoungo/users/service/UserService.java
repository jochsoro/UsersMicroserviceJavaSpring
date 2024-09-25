package com.chonfoungo.users.service;

import com.chonfoungo.users.entities.Role;
import com.chonfoungo.users.entities.User;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}
