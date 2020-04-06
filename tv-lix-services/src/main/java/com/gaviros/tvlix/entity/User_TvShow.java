package com.gaviros.tvlix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Entity
@Table (name = "userTvShow")
@Data
@ToString(includeFieldNames = true)
@JsonInclude(Include.NON_NULL)

public class User_TvShow implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String assessment;
	
	@Column
	private String episode;
	
	@Column
	private String reason;
	
	@Column
	private String season;
	
	@Column
	@NotNull
	private String status;
	
	//@ManyToMany
    @NotNull
	@JoinColumn(name = "fk_users", nullable = false, updatable = false)
	private User user;
	
	//@ManyToMany
    @NotNull
	@JoinColumn(name = "fk_tvshows", nullable = false, updatable = false)
	private TvShow tvShow;
	
	

}
