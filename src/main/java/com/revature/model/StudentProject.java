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
@Table(name = "student_projects", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "STUDENT_ID", "PROJECT_ID" }) })
public class StudentProject {

	public StudentProject() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student studentId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "STARTED_ON")
	private Date startedOn;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "COMPLETED_ON", nullable = true)
	@JsonInclude(Include.NON_NULL)
	private Date completedOn;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "STATUS_ID")
	private Status status;

}
