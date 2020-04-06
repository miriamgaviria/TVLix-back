package com.gaviros.tvlix.apientity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data

public class CountDownApiEntity {
	
	private int season;
	
	private int episode;
	
	private String name;
	
	private String air_date;

}
