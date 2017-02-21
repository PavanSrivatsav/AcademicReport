package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "COLLEGE_ID")
	private College collegeId;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_OF_BIRTH")
	private Date dob;

	@NotNull
	@Column(name = "EMAIL_ID", unique = true)
	private String emailId;

	@NotNull
	private String password;

	@NotNull
	@Column(unique = true)
	private Long phone;

	@NotNull
	private String batch;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department departmentId;

	@NotNull
	@Column(name = "AREA_OF_INTEREST")
	private String areaOfInterest;

	@NotNull
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
}
