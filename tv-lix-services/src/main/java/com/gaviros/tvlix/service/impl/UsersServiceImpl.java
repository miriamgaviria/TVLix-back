package com.gaviros.tvlix.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaviros.tvlix.entity.User;
import com.gaviros.tvlix.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsersServiceImpl {
	
	@Autowired
	UsersRepository usersRepository;	
	

	public int checkIsUser(@Valid User user) {
		
		User userRecovered = new User();
		
		userRecovered = usersRepository.findByUserName(user.getUserName());
		
		if(userRecovered == null || userRecovered.getUserName().isEmpty()) {			
			
			log.info("no hay usuario");

			return 0;  
			
		} else {	
			
			if (user.getUserName().equals(userRecovered.getUserName()) && user.getPassword().equals(userRecovered.getPassword())) {
				
				log.info("coincidencia");

				return 2;
				
			} else {
				
				log.error ("password incorrecta");
				
				return 1;
			}
		}
	}

	public User getUserByUsername(String userName) {
		 
		return usersRepository.findByUserName(userName);
	}

	public void saveUser(User user) {
		
		User userRecovered = new User();
		
		userRecovered = usersRepository.findByUserName(user.getUserName());
		
		if(userRecovered == null || userRecovered.getUserName().isEmpty()) {

			usersRepository.save(user);
			
		} else {
			
			log.error ("Hay usuario");
		}
		
	}


}
