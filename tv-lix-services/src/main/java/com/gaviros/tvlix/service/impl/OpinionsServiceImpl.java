package com.gaviros.tvlix.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaviros.tvlix.entity.Opinion;
import com.gaviros.tvlix.entity.User;
import com.gaviros.tvlix.repository.OpinionsRepository;
import com.gaviros.tvlix.repository.UsersRepository;
import com.gaviros.tvlix.service.OpinionsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OpinionsServiceImpl implements OpinionsService{
	
	@Autowired
	OpinionsRepository opinionsRepository;	
	
	@Autowired
	UsersRepository usersRepository;
	

	@Override
	public List<Opinion> getAllOpinions()  {

		return (List<Opinion>) opinionsRepository.findAll();	
		
	}

	@Override
	public void saveOpinion (Opinion opinion) {

		Date currentDate = new Date();
		
		String strDateFormat = "yyyy-MM-dd HH:mm";
		
		SimpleDateFormat opinionDate = new SimpleDateFormat(strDateFormat);
		
		String opinionDateAsString = opinionDate.format(currentDate);
		
		opinion.setDate(opinionDateAsString);	
		
		try {
			
			opinionsRepository.save(opinion);
			
		} catch (Exception e) {

			log.error("Couldn't post the opinion " + e.getMessage());
			
		}
		
	}

	@Override
	public void deleteOpinion (long id) {
		
		try {
			
			opinionsRepository.deleteById(id);				
			
			
		} catch (Exception e) {

			log.debug(" Couldn't deleteOpinion by id: " + id);	
		}		
	}
}
