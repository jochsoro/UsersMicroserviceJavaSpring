package com.chonfoungo.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chonfoungo.users.entities.Role;
import com.chonfoungo.users.entities.User;
import com.chonfoungo.users.repos.RoleRepository;
import com.chonfoungo.users.repos.UserRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}
	
	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		usr.getRoles().add(r);
		return usr;
	}
	
	@Override
	public Role addRole(Role role) {
		return roleRep.save(role);
	}
	
	@Override
	public User findUserByUsername(String username) {
		return userRep.findByUsername(username);
	}
}
