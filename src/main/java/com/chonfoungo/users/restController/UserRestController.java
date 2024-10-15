package com.chonfoungo.users.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chonfoungo.users.entities.User;
import com.chonfoungo.users.service.UserService;
import com.chonfoungo.users.service.register.RegistationRequest;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
	
		@Autowired
		UserService userService;
		
		
		@GetMapping("all")
		public List<User> getAllUsers() {
			return userService.findAllUsers();
		}
		
		@PostMapping("/register")
		public User registerUser(@RequestBody RegistationRequest request) {
			return userService.registerUser(request);
		}
		
		@GetMapping("/verifyEmail/{token}")
		 public User verifyEmail(@PathVariable("token") String token){ 
			return userService.validateToken(token);
		 }
}
