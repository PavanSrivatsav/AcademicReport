package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StudentDTO {
	private Integer id;
	private String name;
	private Integer collegeId;
	private Date dob;
	private String emailId;
	private String password;
	private String phone;
	private String batch;
	private Integer departmentId;
	private String departmentName;
	private String areaOfInterest;
	private Boolean isActive;
	private String currentCourse;
	private String completedCourse;
	private String currentProject;
	private String completedProject;
	
}
