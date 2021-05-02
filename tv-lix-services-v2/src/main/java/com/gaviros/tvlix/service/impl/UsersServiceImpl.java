package com.gaviros.tvlix.service.impl;

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
		
		try {
			
			User userRecovered = usersRepository.findByUserName(user.getUserName());
			
			if(userRecovered == null || userRecovered.getUserName().isEmpty()) {			
				
				log.info("the user isn't registred on database");

				return 0;  
				
			} else {	
				
				if (user.getUserName().equals(userRecovered.getUserName()) && user.getPassword().equals(userRecovered.getPassword())) {
					
					log.info("the user name and the password are corrected");

					return 2;
					
				} else {
					
					log.info ("the password is not corrected");
					
					return 1;
				}
			}
			
		} catch (Exception e) {
			
			log.error("The user couldn't login " + e.getMessage());
			
			return 0;					
		}		
	}

	@Override
	public User getUserById(long id) {
		
		try {
			
			return usersRepository.findById(id);
			
		} catch (Exception e) {

			log.error("Couldn't get the user by userId " + e.getMessage());
			
			return null;
		}
				 
	}
	
	@Override
	public User getUserByUsername(String userName) {
		
		try {
			
			return usersRepository.findByUserName(userName);
			
		} catch (Exception e) {
			
			log.error("Couldn't get the user by userName " + e.getMessage());

			return null;
			
		}		
	}

	@Override
	public boolean saveUser(User user) {
		
		try {
			
			User userRecovered = new User();
			
			userRecovered = usersRepository.findByUserName(user.getUserName());
			
			if(userRecovered != null && userRecovered.getUserName().equals(user.getUserName())) {
				
				log.info ("user not saved because it is already saved in database");
				
				return false;
				
			} else {				
				
				usersRepository.save(user);
				
				return true;				

			}
			
		} catch (Exception e) {

			return false;
		}		
	}

	@Override
	public boolean updateUser(User user) {
		
		try {
			
			User userRecovered = usersRepository.findById(user.getId());
			
			if(userRecovered.equals(user)) {
				
				log.info ("There is no changes");		
				
				return false;
				
			} else {
				
				usersRepository.save(user);
				
				return true;
			}
			
		} catch (Exception e) {

			log.error("Couldn't update the user " + e.getMessage());
			
			return false;
		}
	}

	@Override
	public void deleteUserById(long id) {
		
		try {
			
			usersRepository.deleteById(id);
			
		} catch (Exception e) {
			
			log.error("Couldn't delete the user " + e.getMessage());
		}
	}
}
