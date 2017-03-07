package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CollegeDTO {
	private Integer id;
	private String name;
	private String Address;
	private String emailId;
	private String phone;
	private Boolean isActive;

}
