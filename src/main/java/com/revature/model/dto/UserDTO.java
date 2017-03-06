package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class UserDTO {
	private Integer id;
	private String name;
	private Integer roleId;
	private String emailId;
	@JsonInclude(Include.NON_NULL)
	private String password;
	private String phone;
	private Integer collegeId;
	private Integer departmentId;
	private Boolean isActive;

}
