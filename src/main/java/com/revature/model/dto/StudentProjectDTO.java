package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.revature.model.Project;
import com.revature.model.Status;
import com.revature.model.Student;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StudentProjectDTO {
	private Integer id;
	private Student studentId;
	private Project project;
	private Date startedOn;
	private Date completedOn;
	private Status status;

}
