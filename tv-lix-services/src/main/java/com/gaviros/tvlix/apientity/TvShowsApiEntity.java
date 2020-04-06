package com.gaviros.tvlix.apientity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data

public class TvShowsApiEntity {
	
	private int id;
	
	private String name;
	
	private String permalink;
	
	private String start_date;
	
	private String  end_date;

	private String country;

	private String  network;

	private String status;

	private String image_thumbnail_path;

}
