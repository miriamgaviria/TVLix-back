package com.gaviros.tvlix.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaviros.tvlix.entity.TvShow;
import com.gaviros.tvlix.entity.User;
import com.gaviros.tvlix.entity.UserTvShow;
import com.gaviros.tvlix.repository.TvShowsRepository;
import com.gaviros.tvlix.repository.UserTvShowRepository;
import com.gaviros.tvlix.repository.UsersRepository;
import com.gaviros.tvlix.service.TvShowsService;
import com.gaviros.tvlix.service.UserTvShowsService;

@Service
public class UserTvShowsServiceImpl implements UserTvShowsService{
	
	@Autowired
	UserTvShowRepository userTvShowRepository;
	
	@Autowired
	TvShowsRepository tvShowsRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	private TvShowsService tvShowsService;

	@Override
	public List<UserTvShow> getAllUserTvShows() {

		List<UserTvShow> allUserTvShows = (List<UserTvShow>) userTvShowRepository.findAll();

		return allUserTvShows;
	}

	@Override
	public boolean saveTvShow(@Valid UserTvShow userTvShow) {

		TvShow tvShowRecovered = tvShowsRepository.findById(userTvShow.getTvShow().getId());
		
		if (tvShowRecovered == null) {
			
			tvShowsRepository.save(userTvShow.getTvShow());
			
			return true;
			
		} else {
			
			if (userTvShow.getTvShow().getEpisodes().equals(tvShowRecovered.getEpisodes()) && userTvShow.getTvShow().getStatus().equals(tvShowRecovered.getStatus())) {
				
				return false;
				
			} else {
				
				tvShowsRepository.save(userTvShow.getTvShow());
				
				return true;			
			}
			
		}

	}

	@Override
	public List<UserTvShow> getUserTvShowsByStatus(@Valid long userId, @Valid int watchedStatus) {
		
		try {
			
			User user = usersRepository.findById(userId);
			
			List<UserTvShow> userTvShows = userTvShowRepository.findByUser(user);
			
			List<UserTvShow> userTvShowsByStatus = userTvShows.stream().filter(tvShow -> tvShow.watchedStatus == watchedStatus).collect(Collectors.toList());
			
			System.out.print(userTvShowsByStatus);
			
			return userTvShowsByStatus; 
			
		} catch (Exception e) {
			List<UserTvShow> emptyList = null;
			System.out.print(e.getMessage());
			
			return emptyList;
		}
		
		
	}

}
