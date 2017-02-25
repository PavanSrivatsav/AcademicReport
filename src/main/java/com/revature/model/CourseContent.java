package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "course_contents", uniqueConstraints = { @UniqueConstraint(columnNames = { "COURSE_ID", "VIDEO_ID" }),
		@UniqueConstraint(columnNames = { "COURSE_ID", "TEXT_CONTENT" }) })
public class CourseContent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "COURSE_ID")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "VIDEO_ID", nullable = true)
	private Video video;

	@Column(name = "TEXT_CONTENT", nullable = true)
	private String textContent;

	@NotNull
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

}