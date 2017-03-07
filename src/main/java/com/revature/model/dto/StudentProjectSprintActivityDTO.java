package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.revature.model.ProjectSprintActivity;
import com.revature.model.Status;
import com.revature.model.StudentProjectSprint;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StudentProjectSprintActivityDTO {
	private Integer id;
	private StudentProjectSprint studentProjectSprint;
	private ProjectSprintActivity projectSprintActivity;
	private Date startedOn;
	private Date completedOn;
	private Status statusId;

}
