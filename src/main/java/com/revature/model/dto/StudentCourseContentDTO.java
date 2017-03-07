package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.revature.model.CourseContent;
import com.revature.model.Status;
import com.revature.model.StudentCourse;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StudentCourseContentDTO {
	private Integer id;
	private StudentCourse studentCourseId;
	private CourseContent courseContentId;
	private Date startedOn;
	private Date completedOn;
	private Status statusId;

}
