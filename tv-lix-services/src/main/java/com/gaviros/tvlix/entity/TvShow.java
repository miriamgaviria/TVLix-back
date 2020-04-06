package com.gaviros.tvlix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Entity
@Table (name = "tvshows")
@Data
@ToString(includeFieldNames = true)
@JsonInclude(Include.NON_NULL)

public class TvShow implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	
    @Column
	private String actors;    
	
	@Column
	private String director;
	
	@Column
	private String genre;
    	
	@Column
	private String permalink;
	
	@Column
	private String picture_url;
	
	@Column
	private String plot;
	
	@Column
	private String seasons;
	
	@Column
	private String status;	
	
	@Column
	private String title;
}
