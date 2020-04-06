package com.gaviros.tvlix.apientity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data

public class TvShowApiEntity {
	
	private int id;
	
	private String name;
	
	private String permalink;
	
	private String url;
	
	private String description;
	
	private String description_source;
	
	private String start_date;
    
	private String end_date;
    
	private String country;
    
	private String status;
    
	private String runtime;
    
	private String network;
	
	private String youtube_link;
    
	private String image_path;
    
	private String image_thumbnail_path;
    
	private String rating;
	
	private String rating_count;
	
	private CountDownApiEntity countdown;
    
	private String genres [];
	
	private String pictures [];
	
	private EpisodesApiEntity episodesApiEntity [];

}
