package com.gaviros.tvlix.service;

import java.util.List;

import javax.validation.Valid;

import com.gaviros.tvlix.entity.Opinion;

public interface OpinionsService {
	
	public abstract List <Opinion> getAllOpinions ();
	
	public abstract void saveOpinion (Opinion opinion);
	
	// Method to probe
	public abstract void updateOpinion(@Valid Opinion opinion);

	public abstract void deleteOpinion (long id);

	
	

}
