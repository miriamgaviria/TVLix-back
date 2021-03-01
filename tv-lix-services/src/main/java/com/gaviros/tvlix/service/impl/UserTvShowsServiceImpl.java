package com.gaviros.tvlix.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.gaviros.tvlix.service.UserTvShowsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserTvShowsServiceImpl implements UserTvShowsService{
	
	@Autowired
	UserTvShowRepository userTvShowRepository;
	
	@Autowired
	TvShowsRepository tvShowsRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public List<UserTvShow> getAllUserTvShows() {
		
		try {			
			
			return (List<UserTvShow>) userTvShowRepository.findAll();
			
		} catch (Exception e) {

			log.error("Couldn't get all userTvShows " + e.getMessage());	
			
			return null;
		}
	}
	
	@Override
	public List<UserTvShow> getUserTvShows(@Valid long userId) {
		
		try {
			
			User user = usersRepository.findById(userId);
			
			List<UserTvShow> userTvShows = userTvShowRepository.findByUser(user);
			
			return userTvShows; 
			
		} catch (Exception e) {
			 
			log.error("Couldn't get  the user userTvShows " + e.getMessage());	
			
			return null;
		}		
	}

	@Override
	public List<UserTvShow> getUserTvShowsByStatus(@Valid long userId, @Valid String watchedStatus) {
		
		try {
			
			List<UserTvShow> userTvShows = getUserTvShows(userId);
			
			List<UserTvShow> userTvShowsByStatus = userTvShows.stream().filter(tvShow -> tvShow.watchedStatus.equals(watchedStatus)).collect(Collectors.toList());
			
			return userTvShowsByStatus; 
			
		} catch (Exception e) {
			
			log.error("Couldn't get the user userTvShows by watchedStatus " + e.getMessage());	
			
			return null;
		}		
	}

	@Override
	public void saveUserTvShow(@Valid UserTvShow userTvShow) {
		
		String userTvShowDateAsString = getCurrentDate();
		
		userTvShow.setDate(userTvShowDateAsString);	
		
		try {
			
			TvShow tvShowRecovered = tvShowsRepository.findById(userTvShow.getTvShow().getId());
			
			if (tvShowRecovered == null) {
				
				tvShowsRepository.save(userTvShow.getTvShow());
				userTvShowRepository.save(userTvShow);		
				
				System.out.println("tvShow saved on tvShows table and userTvShows table" );
				
			} else {
				
				UserTvShow userTvShowRecovered = getUserTvShowByTvShowId(userTvShow);
				
				if (userTvShowRecovered == null) {
					
					userTvShowRepository.save(userTvShow);
					
					System.out.println("userTvShow save on userTvShows table" );	
					
				} 		
			}
			
		} catch (Exception e) {

			log.error("Couldn't get the user userTvShows by watchedStatus " + e.getMessage());	
			
		}		
	}

	@Override
	public void updateUserTvShow(@Valid UserTvShow userTvShow) {
		
		String userTvShowDateAsString = getCurrentDate();
		
		userTvShow.setDate(userTvShowDateAsString);	

		UserTvShow userTvShowRecovered = getUserTvShowByTvShowId(userTvShow);
		
		try {
			
			if (userTvShow.equals(userTvShowRecovered)) {
				
				System.out.println("userTvShow not saved because it is already saved in database");
				
			}	else {
				
				userTvShowRepository.save(userTvShow);
				
				System.out.println("usrTvShow updated" );
			}
			
		} catch (Exception e) {
			
			log.error("Couldn't update the userTvShow " + e.getMessage());	
		}
		
	}	
	

	private String getCurrentDate() {
		
		Date currentDate = new Date();
		
		String strDateFormat = "yyyy-MM-dd";
		
		SimpleDateFormat userTvShowDate = new SimpleDateFormat(strDateFormat);
		
		return userTvShowDate.format(currentDate);
	}

	private UserTvShow getUserTvShowByTvShowId(UserTvShow userTvShow) {
		
		try {
			
			List <UserTvShow> userTvShowListRecovered = userTvShowRepository.findByUser(userTvShow.getUser());
			
			UserTvShow userTvShowById = null;
			for (UserTvShow userTvShowRecovered : userTvShowListRecovered) {
				if (userTvShowRecovered.getTvShow().getId() == userTvShow.getTvShow().getId()) {
					userTvShowById = userTvShowRecovered;
				}			
			}
			
			return userTvShowById;
			
		} catch (Exception e) {

			log.error("Couldn't get userTvShowByTvShowId " + e.getMessage());
			
			return null;
			
		}
		
	}

	@Override
	public void deleteTvShowUserById(@Valid long id) {
		
		try {
			
			userTvShowRepository.deleteById(id);
			
		} catch (Exception e) {
			
			log.error("Couldn't delete the userTvShow " + e.getMessage());	

		}
	}
}
