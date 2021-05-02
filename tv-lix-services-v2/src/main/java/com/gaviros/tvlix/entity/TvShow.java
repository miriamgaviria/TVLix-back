package com.gaviros.tvlix.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column
//	@OneToMany
	private long id;	
	
	@Column
	private String name;

	@Column
	private String runTime;
	
	@Column	
	private String genre;
    	
	@Column
	private String seasons;
	
	@Column
	private String episodes;
		
	@Column
	private String rating;
	
	@Column
	private String rating_count;
	
	@Column
	private String status;
	
	@Column
	private String sinopsis;
	
	@Column
	private String image;	
	
	@Column
	private String start_date;	
	
	@Column
	private String end_date;
}
