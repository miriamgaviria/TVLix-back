package com.gaviros.tvlix.service.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaviros.tvlix.entity.User;
import com.gaviros.tvlix.repository.UsersRepository;
import com.gaviros.tvlix.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UsersRepository usersRepository;	
	
	@Override
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

	@Override
	public User getUserByUsername(String userName) {
				 
		return usersRepository.findByUserName(userName);
	}

	@Override
	public boolean saveUser(User user) {
		
		User userRecovered = new User();
		
		userRecovered = usersRepository.findByUserName(user.getUserName());
		
		if(userRecovered == null || userRecovered.getUserName().isEmpty()) {

			usersRepository.save(user);
			
			return true;
			
		} else {
			
			log.error ("Hay usuario");
			
			return false;
		}
		
	}

	@Override
	public boolean updateUser(User user) {
		
		User userRecovered = getUserById(4);
		
		long userId = (long) user.getId();
		
		userRecovered = usersRepository.findById(userId);
	
		if(userRecovered.equals(user)) {

			log.error ("No ha habido cambios");		
			
			return false;
			
		} else {
			
			usersRepository.delete(userRecovered);
			
			usersRepository.save(user);
			
			return true;
		}
	}

	@Override
	public User getUserById(long id) {
				 
		return usersRepository.findById(id);
	}

	@Override
	public boolean deleteUserById(long id) {
		
		try {
			
			usersRepository.deleteById(id);
			return true;
			
		} catch (Exception e) {
			
			System.out.print(e.getMessage());
			return false;
		}
	}
}
