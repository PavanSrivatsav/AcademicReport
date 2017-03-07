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
@Table(name = "project_sprint_activities")
public class ProjectSprintActivity {

	public ProjectSprintActivity() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "PROJECT_SPRINT_ID")
	private ProjectSprint projectSprintId;

	@ManyToOne
	@JoinColumn(name = "VIDEO_ID", nullable = true)
	@JsonInclude(Include.NON_NULL)
	private Video video;

	@ManyToOne
	@JoinColumn(name = "COURSE_ID", nullable = true)
	@JsonInclude(Include.NON_NULL)
	private Course course;

	@ManyToOne
	@JoinColumn(name = "QUIZ_ID", nullable = true)
	@JsonInclude(Include.NON_NULL)
	private Quiz quiz;

	@Column(name = "ONLINE_ACTIVITY", nullable = true)
	@JsonInclude(Include.NON_NULL)
	private String onlineActivity;

	@Column(name = "OFFLINE_ACTIVITY", nullable = true)
	@JsonInclude(Include.NON_NULL)
	private String offlineActivity;

	@NotNull
	@Column(name = "DURATION_IN_MINUTES")
	private Integer duration;

	@NotNull
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
}
