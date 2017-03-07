package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.revature.model.ProjectSprint;
import com.revature.model.Status;
import com.revature.model.StudentProject;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StudentProjectSprintDTO {
	private Integer id;
	private StudentProject studentProject;
	private ProjectSprint projectSprint;
	private Date startedOn;
	private Date completedOn;
	private Status statusId;

}
