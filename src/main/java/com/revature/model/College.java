package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "colleges")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	@NotNull
	private String name;

	@NotNull
	private String Address;

	@Column(name = "EMAIL_ID", unique = true)
	@NotNull
	private String emailId;

	@Column(unique = true)
	@NotNull
	private Long phone;

	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

}
