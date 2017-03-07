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
@Table(name = "project_sprints", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "PROJECT_ID", "SPRINT_NAME" }) })
public class ProjectSprint {

	public ProjectSprint() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	@NotNull
	@Column(name = "SPRINT_NAME")
	private String sprintName;

	@NotNull
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

}
