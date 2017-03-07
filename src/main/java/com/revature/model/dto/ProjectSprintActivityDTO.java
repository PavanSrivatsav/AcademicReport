package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.revature.model.Course;
import com.revature.model.ProjectSprint;
import com.revature.model.Quiz;
import com.revature.model.Video;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProjectSprintActivityDTO {
	private Integer id;
	private ProjectSprint projectSprintId;
	private Video video;
	private Course course;
	private Quiz quiz;
	private String onlineActivity;
	private String offlineActivity;
	private Integer duration;
	private Boolean isActive;

}
