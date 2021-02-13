package com.gaviros.tvlix.service;

import java.util.List;

import javax.validation.Valid;

import com.gaviros.tvlix.entity.TvShow;
import com.gaviros.tvlix.entity.UserTvShow;

public interface UserTvShowsService {
	
	public abstract List <UserTvShow> getAllUserTvShows();

	public abstract List<UserTvShow> getUserTvShowsByStatus(@Valid long userId, @Valid int watchedStatus);

	public abstract boolean saveTvShow(@Valid UserTvShow userTvShow);


}
