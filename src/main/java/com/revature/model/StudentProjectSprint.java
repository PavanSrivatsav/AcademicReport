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

import lombok.Data;

@Data
@Entity
@Table(name = "student_project_sprints", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "STUDENT_PROJECT_ID", "PROJECT_SPRINT_ID" }) })
public class StudentProjectSprint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "STUDENT_PROJECT_ID")
	private StudentProject studentProject;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "PROJECT_SPRINT_ID")
	private ProjectSprint projectSprint;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "STARTED_ON")
	private Date startedOn;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "COMPLETED_ON", nullable = true)
	private Date completedOn;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "STATUS_ID")
	private Status statusId;

}
