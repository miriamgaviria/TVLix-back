package com.gaviros.tvlix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaviros.tvlix.entity.Opinion;
import com.gaviros.tvlix.entity.User;
import com.gaviros.tvlix.service.impl.UsersServiceImpl;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("/users")
public class UsersController {
	
	@Autowired
	private UsersServiceImpl usersService;
	
	@PostMapping ("/isUser")
	public int checkIsUser (@RequestBody @Valid User user) {
		return usersService.checkIsUser(user);
	}

//	@GetMapping
//	public User getUserByUsername(@RequestBody @Valid User user) {
//		
//		return usersService.getUserByUsername(user.getUserName());
//	}
	
	@PostMapping
	public void postUser(@RequestBody @Valid User user) {
		
		usersService.saveUser(user);
	}
}

