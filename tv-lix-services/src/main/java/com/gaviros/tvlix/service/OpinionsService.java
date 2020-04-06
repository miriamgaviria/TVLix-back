package com.gaviros.tvlix.service;

import java.util.List;

import com.gaviros.tvlix.entity.Opinion;

public interface OpinionsService {
	
	public abstract List <Opinion> getAllOpinions ();
	
	public abstract void saveOpinion (Opinion opinion);
	
	public abstract void deleteOpinion (long id);
	
	

}
