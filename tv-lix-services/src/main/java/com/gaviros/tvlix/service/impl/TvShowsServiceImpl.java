package com.gaviros.tvlix.service.impl;

import java.util.List;

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
	TvShowsRepository tvShowsServiceRepository;

	@Override
	public List<TvShow> getAllTvShows() {

		List<TvShow> allTvShows = (List<TvShow>) tvShowsServiceRepository.findAll();

		return allTvShows;

	}
}
