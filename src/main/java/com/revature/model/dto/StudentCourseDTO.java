package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StudentCourseDTO {
	private Integer id;
	private Integer studentId;
	private Integer courseId;
	private Date startedOn;
	private Date completedOn;
	private Integer statusId;

}
