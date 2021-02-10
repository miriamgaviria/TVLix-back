package com.gaviros.tvlix.repository;

import org.springframework.data.repository.CrudRepository;

import com.gaviros.tvlix.entity.TvShow;
import com.gaviros.tvlix.entity.User;

public interface TvShowsRepository extends CrudRepository<TvShow, Long> {
	
	public abstract TvShow findById(long id);

}
