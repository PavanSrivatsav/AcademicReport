package com.revature.model;

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

@Data
@Entity
@Table(name = "users")
@JsonInclude(Include.NON_NULL)
public class User {

	public User() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role roleId;

	@NotNull
	@Column(name = "EMAIL_ID", unique = true)
	private String emailId;

	@NotNull
	@JsonInclude(Include.NON_NULL)
	private String password;

	@NotNull
	@Column(unique = true)
	private String phone;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "COLLEGE_ID")
	private College collegeId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department departmentId;

	@NotNull
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

}