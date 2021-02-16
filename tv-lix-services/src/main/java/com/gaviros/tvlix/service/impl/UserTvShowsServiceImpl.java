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
	public List<UserTvShow> getUserTvShows(@Valid long userId) {
		
		try {
			
			User user = usersRepository.findById(userId);
			
			List<UserTvShow> userTvShows = userTvShowRepository.findByUser(user);
			
			return userTvShows; 
			
		} catch (Exception e) {
			
			List<UserTvShow> emptyList = null;
			
			System.out.print(e.getMessage());
			
			return emptyList;
		}		
	}

	@Override
	public List<UserTvShow> getUserTvShowsByStatus(@Valid long userId, @Valid String watchedStatus) {
		
		try {
			
			List<UserTvShow> userTvShows = getUserTvShows(userId);
			
			List<UserTvShow> userTvShowsByStatus = userTvShows.stream().filter(tvShow -> tvShow.watchedStatus.equals(watchedStatus)).collect(Collectors.toList());
			
			return userTvShowsByStatus; 
			
		} catch (Exception e) {
			
			List<UserTvShow> emptyList = null;
			
			System.out.print(e.getMessage());
			
			return emptyList;
		}		
	}

	@Override
	public boolean saveUserTvShow(@Valid UserTvShow userTvShow) {

		TvShow tvShowRecovered = tvShowsRepository.findById(userTvShow.getTvShow().getId());
		
		if (tvShowRecovered == null) {
			
			tvShowsRepository.save(userTvShow.getTvShow());
			userTvShowRepository.save(userTvShow);		
			
			System.out.println("guardada en tvShow y userTvShow " );
			return true;
			
		} else {
			
			UserTvShow userTvShowRecovered = getUserTvShowByTvShowId(userTvShow);
			
			if (userTvShowRecovered == null) {
				
				userTvShowRepository.save(userTvShow);
				
				System.out.println("guardada nueva en userTvShow " );			
				
				return true;	
			
			} else {				
				
				return false;			
				
			}			
		}
	}

	@Override
	public boolean updateUserTvShow(@Valid UserTvShow userTvShow) {

		UserTvShow userTvShowRecovered = getUserTvShowByTvShowId(userTvShow);
		
		//if (userTvShow.getTvShow().getEpisodes().equals(userTvShowRecovered.getTvShow().getEpisodes()) && userTvShow.getTvShow().getStatus().equals(userTvShowRecovered.getTvShow().getStatus())) {
		if (userTvShow.equals(userTvShowRecovered)) {
				
			System.out.println("no guardada " );
			
			return false;	
				
		}	else {
				
			userTvShowRepository.save(userTvShow);
			
			System.out.println("actualizar " );
			
			return true;
		}
	}	

	private UserTvShow getUserTvShowByTvShowId(UserTvShow userTvShow) {
		
		List <UserTvShow> userTvShowListRecovered = userTvShowRepository.findByUser(userTvShow.getUser());
		
		UserTvShow userTvShowById = null;
		for (UserTvShow userTvShowRecovered : userTvShowListRecovered) {
			if (userTvShowRecovered.getTvShow().getId() == userTvShow.getTvShow().getId()) {
				userTvShowById = userTvShowRecovered;
			}			
		}
		return userTvShowById;
	}

	@Override
	public boolean deleteTvShowUserById(@Valid long id) {
		try {
			
			userTvShowRepository.deleteById(id);
			return true;
			
		} catch (Exception e) {
			
			System.out.print(e.getMessage());
			return false;
		}
	}
}
