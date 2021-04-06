package com.gaviros.tvlix.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaviros.tvlix.entity.User;
import com.gaviros.tvlix.service.UsersService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping ("/isUser")
	public int checkIsUser (@RequestBody @Valid User user) {
		
		return usersService.checkIsUser(user);
	}

	@GetMapping("/userName/{userName}")
	public User getUserByUsername(@PathVariable (required = true) @Valid String userName) {	
		
		return usersService.getUserByUsername(userName);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable (required = true) @Valid long id) {		
		
		return usersService.getUserById(id);
	}
	
	@PostMapping
	public boolean postUser(@RequestBody @Valid User user) {
		
		return usersService.saveUser(user);
	}
	
	@PutMapping
	public boolean putUser(@RequestBody @Valid User user) {
		
		return usersService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable (required = true) @Valid long id) {	
		
		usersService.deleteUserById(id);
	}	
}

