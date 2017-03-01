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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "student_course_contents", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "STUDENT_COURSE_ID", "COURSE_CONTENT_ID" }) })
public class StudentCourseContent {

	private StudentCourseContent() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "STUDENT_COURSE_ID")
	private StudentCourse studentCourseId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "COURSE_CONTENT_ID")
	private CourseContent courseContentId;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "STARTED_ON")
	private Date startedOn;

	@Temporal(TemporalType.DATE)
	@Column(name = "COMPLETED_ON", nullable = true)
	@JsonInclude(Include.NON_NULL)
	private Date completedOn;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "STATUS_ID")
	private Status statusId;

}
