package com.gaviros.tvlix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Entity
@Table (name = "users")
@Data
@ToString(includeFieldNames = true)
@JsonInclude(Include.NON_NULL)

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
		
	@Column
	private String genre;
	
	@Column
	private String location;
	
	@Column
	private String name;
	
    @Column
	private String email;
	
	@Column
	@NotNull
	private String password;
	
	@Column
	private String surname;
	
	@Column
	private String typeMedia;

	@Column
	@NotNull
	private String userName;
}
