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

import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(unique = true)
	private String name;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category categoryId;

	@NotNull
	private String description;

	@NotNull
	@Column(name = "DURATION_IN_MINUTES")
	private Integer duration;

	@NotNull
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

}
