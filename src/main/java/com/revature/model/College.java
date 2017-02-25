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

	private College() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(unique = true)
	private String name;

	@NotNull
	private String Address;

	@NotNull
	@Column(name = "EMAIL_ID", unique = true)
	private String emailId;

	@NotNull
	@Column(unique = true)
	private Long phone;

	@NotNull
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

}
