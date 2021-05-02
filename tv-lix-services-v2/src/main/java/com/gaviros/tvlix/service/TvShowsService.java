package com.gaviros.tvlix.service;

import java.util.List;

import javax.validation.Valid;

import com.gaviros.tvlix.entity.TvShow;

public interface TvShowsService {
	
	public abstract List <TvShow> getAllTvShows();
	
	public abstract TvShow getTvShowById(long id);

	public abstract void saveTvShow(TvShow tvShow);
	
	public abstract void updateTvShow(TvShow tvShow);
	
	public abstract boolean deleteTvShowById(long id);

}
