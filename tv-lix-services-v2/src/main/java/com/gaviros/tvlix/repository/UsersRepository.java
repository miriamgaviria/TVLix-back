package com.gaviros.tvlix.repository;

import org.springframework.data.repository.CrudRepository;

import com.gaviros.tvlix.entity.User;

public interface UsersRepository extends CrudRepository<User, Long>{

	public abstract User findByUserName(String userName);
	
	public abstract User findById(long id);
}
