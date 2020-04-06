package com.gaviros.tvlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaviros.tvlix.entity.TvShow;
import com.gaviros.tvlix.service.TvShowsService;
import com.gaviros.tvlix.service.impl.TvShowsServiceImpl;

import java.util.List;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("/tvShows")
public class TvShowsController {
	
	@Autowired
	private TvShowsServiceImpl tvShowsService;
	
	@GetMapping
	public List <TvShow> getTvShows() {
		
		return tvShowsService.getAllTvShows();
	}

}
