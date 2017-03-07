package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.revature.model.Course;
import com.revature.model.Status;
import com.revature.model.Student;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StudentCourseDTO {
	private Integer id;
	private Student student;
	private Course course;
	private Date startedOn;
	private Date completedOn;
	private Status statusId;

}
