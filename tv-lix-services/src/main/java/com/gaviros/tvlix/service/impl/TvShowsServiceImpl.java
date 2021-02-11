package com.gaviros.tvlix.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaviros.tvlix.entity.TvShow;
import com.gaviros.tvlix.service.TvShowsService;
import com.gaviros.tvlix.repository.TvShowsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TvShowsServiceImpl implements TvShowsService {

	@Autowired
	TvShowsRepository tvShowsRepository;

	@Override
	public List<TvShow> getAllTvShows() {

		List<TvShow> allTvShows = (List<TvShow>) tvShowsRepository.findAll();

		return allTvShows;

	}
	
	@Override
	public TvShow getTvShowById(long id) {
		
		return tvShowsRepository.findById(id);
	}
	
	public boolean saveTvShow(@Valid TvShow tvShow) {

		if (tvShowsRepository.findById(tvShow.getId()) == null) {
			
			tvShowsRepository.save(tvShow);
			
			return true;
			
		} else {
			
			return false;
			
		}
	}

	@Override
	public boolean updateTvShow(TvShow tvShow) {
		
		TvShow tvShowRecovered = tvShowsRepository.findById(tvShow.getId());
		
		if (tvShow.getEpisodes().equals(tvShowRecovered.getEpisodes()) && tvShow.getStatus().equals(tvShowRecovered.getStatus())) {
			
			return false;
			
		} else {
			
			tvShowsRepository.save(tvShow);
			
			return true;			
		}

	}

	@Override
	public boolean deleteTvShowById(long id) {
		try {
			
			tvShowsRepository.deleteById(id);
			return true;
			
		} catch (Exception e) {
			
			System.out.print(e.getMessage());
			return false;
		}
	}
}
