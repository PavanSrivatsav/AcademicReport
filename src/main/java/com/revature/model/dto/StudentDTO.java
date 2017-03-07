package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.revature.model.College;
import com.revature.model.Department;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StudentDTO {
	private Integer id;
	private String name;
	private College college;
	private Date dob;
	private String emailId;
	private String password;
	private String phone;
	private String batch;
	private Department department;
	private String areaOfInterest;
	private Boolean isActive;
	
}
