package com.gaviros.tvlix.apientity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data

public class GetTvShowsApiEntity {
	
	private String total;
	
	private int page;
	
	private int pages;
	
	private TvShowsApiEntity
	tvShows;
	
	
    

}
