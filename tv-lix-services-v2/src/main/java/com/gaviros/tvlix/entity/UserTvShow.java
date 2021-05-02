package com.gaviros.tvlix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Entity
@Table (name = "userTvShows")
@Data
@ToString(includeFieldNames = true)
@JsonInclude(Include.NON_NULL)

public class UserTvShow implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "FK_USER", nullable = false, updatable = false)
	private User user;	
    
	@ManyToOne
    @NotNull
	@JoinColumn(name = "FK_TVSHOW", nullable = false, updatable = false)
	private TvShow tvShow;
		
	@Column
	@NotNull
	public String watchedStatus;
	
	@Column
	private String rate;
	
	@Column
	private String opinion;
	
	@Column
	private String date;
		
	@Column
	private String seasonWatched;
	
	@Column
	private String episodeWatched;
	
	@Column
	private String reason;

	@Column
	private String platform;
}
