package com.gaviros.tvlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaviros.tvlix.entity.TvShow;
import com.gaviros.tvlix.service.TvShowsService;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("/tvShows")
public class TvShowsController {
	
	@Autowired
	private TvShowsService tvShowsService;
	
	@GetMapping
	public List <TvShow> getTvShows() {
		
		return tvShowsService.getAllTvShows();
	}

	@GetMapping("/{id}")
	public TvShow getTvShowById(@PathVariable (required = true) @Valid long id) {		
		return tvShowsService.getTvShowById(id);
	}
	
	@PostMapping
	public boolean postTvShow(@RequestBody @Valid TvShow tvShow) {
		
		return tvShowsService.saveTvShow(tvShow);
	}
	
	@PutMapping
	public boolean putTvShow(@RequestBody @Valid TvShow tvShow) {
		
		return tvShowsService.updateTvShow(tvShow);
	}
	
	@DeleteMapping("/{id}")
	public boolean DeleteTvShowById(@PathVariable (required = true) @Valid long id) {		
		return tvShowsService.deleteTvShowById(id);
	}
}
