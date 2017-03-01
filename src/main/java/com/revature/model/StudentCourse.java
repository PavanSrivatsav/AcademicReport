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

import lombok.Data;

@Data
@Entity
@Table(name = "student_courses", uniqueConstraints = { @UniqueConstraint(columnNames = { "STUDENT_ID", "COURSE_ID" }) })
public class StudentCourse {

	private StudentCourse() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "COURSE_ID")
	private Course course;

	@NotNull
	@Column(name = "STARTED_ON")
	@Temporal(TemporalType.DATE)
	private Date startedOn;

	@Column(name = "COMPLETED_ON", nullable = true)
	@JsonInclude(Include.NON_NULL)
	@Temporal(TemporalType.DATE)
	private Date completedOn;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "STATUS_ID")
	private Status statusId;

}
