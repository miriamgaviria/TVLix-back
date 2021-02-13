package com.gaviros.tvlix.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gaviros.tvlix.entity.TvShow;
import com.gaviros.tvlix.entity.User;
import com.gaviros.tvlix.entity.UserTvShow;

public interface UserTvShowRepository extends CrudRepository<UserTvShow, Long> {
	
	List<UserTvShow> findByUser(User user);

	UserTvShow findByTvShow(TvShow tvShow);

}
