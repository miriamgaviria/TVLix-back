package com.gaviros.tvlix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Entity
@Table (name = "opinions")
@Data
@ToString(includeFieldNames = true)
@JsonInclude(Include.NON_NULL)

public class Opinion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	
	@Column
	private String date;	
	
	@Column
	private String comment;	
	
	@Column
	@NotNull
	private String rate;
	
	@ManyToOne
	@JoinColumn(name = "FK_USER", nullable = false, updatable = false)
	private User user;	
}
