package com.gaviros.tvlix.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gaviros.tvlix.entity.UserTvShow;

public interface UserTvShowRepository extends CrudRepository<UserTvShow, Long> {

	@Query(value = "SELECT * FROM user_tv_shows WHERE watched_status = :watchedStatus", nativeQuery = true)
	public abstract List<UserTvShow> getUserTvShowsByStatus(@Param(value="watchedStatus")int watchedStatus);

}
