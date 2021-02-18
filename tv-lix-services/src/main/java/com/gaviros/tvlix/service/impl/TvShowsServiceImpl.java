package com.gaviros.tvlix.service.impl;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaviros.tvlix.entity.TvShow;
import com.gaviros.tvlix.service.TvShowsService;

import lombok.extern.slf4j.Slf4j;

import com.gaviros.tvlix.repository.TvShowsRepository;

@Slf4j
@Service
public class TvShowsServiceImpl implements TvShowsService {

	@Autowired
	TvShowsRepository tvShowsRepository;

	@Override
	public List<TvShow> getAllTvShows() {
		
		try {
			
			List<TvShow> allTvShows = (List<TvShow>) tvShowsRepository.findAll();
			
			return allTvShows;
			
		} catch (Exception e) {
			
			log.error("Couldn't get de tvShows" + e.getMessage());			

			return null;
		}
	}
	
	@Override
	public TvShow getTvShowById(long id) {
		
		return tvShowsRepository.findById(id);
	}
	
	public void saveTvShow(@Valid TvShow tvShow) {
		
		try {
			
			if (tvShowsRepository.findById(tvShow.getId()) == null) {
				
				tvShowsRepository.save(tvShow);
			}
			
		} catch (Exception e) {

			log.error("The tvShow couldn't been saved " + e.getMessage());
			
		}

	}

	@Override
	public void updateTvShow(TvShow tvShow) {
		
		try {
			
			TvShow tvShowRecovered = tvShowsRepository.findById(tvShow.getId());
			
			if (tvShow.getEpisodes().equals(tvShowRecovered.getEpisodes()) && tvShow.getStatus().equals(tvShowRecovered.getStatus())) {
				
			} else {
				
				tvShowsRepository.save(tvShow);
			}			
			
		} catch (Exception e) {
			
			log.error("The tvShow couldn't been updated " + e.getMessage());
			
		}		
	}

	@Override
	public boolean deleteTvShowById(long id) {
		
		try {
			
			tvShowsRepository.deleteById(id);
			
			return true;
			
		} catch (Exception e) {
			
			log.error("The tvShow hasn't been delete " + e.getMessage());
			
			return false;
		}
	}
}
