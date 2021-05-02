package com.gaviros.tvlix.service;

import com.gaviros.tvlix.entity.User;

public interface UsersService {
	
	public abstract int checkIsUser(User user);
	
	public abstract User getUserByUsername(String userName);
	
	public abstract User getUserById(long id);
	
	public abstract boolean saveUser(User user); 
	
	public abstract boolean updateUser(User user); 
	
	public abstract void deleteUserById(long id);

}
