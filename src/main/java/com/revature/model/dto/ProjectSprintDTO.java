package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.revature.model.Project;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProjectSprintDTO {
	private Integer id;
	private Project project;
	private String sprintName;
	private Boolean isActive;

}
