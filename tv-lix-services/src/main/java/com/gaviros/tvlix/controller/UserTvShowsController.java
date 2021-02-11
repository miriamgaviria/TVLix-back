package com.gaviros.tvlix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaviros.tvlix.entity.TvShow;
import com.gaviros.tvlix.entity.UserTvShow;
import com.gaviros.tvlix.service.UserTvShowsService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("/user_tv_shows")

public class UserTvShowsController {
	
	@Autowired
	private UserTvShowsService userTvShowsService;

	
	@GetMapping 
	public List <UserTvShow> getUserTvShows() {
		
		return userTvShowsService.getAllUserTvShows();
		
	}
	
	@GetMapping("/{watchedStatus}")
	public List <UserTvShow> getUserTvShowsByStatus(@PathVariable (required = true) @Valid int watchedStatus) {
		
		return userTvShowsService.getUserTvShowsByStatus(watchedStatus);
	}
	
	@PostMapping
	public boolean postUserTvShow(@RequestBody @Valid UserTvShow userTvShow) {
		
		return userTvShowsService.saveTvShow(userTvShow);
	}

}
