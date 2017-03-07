package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.revature.model.Category;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CourseDTO {
	private Integer id;
	private String name;
	private Category category;
	private String description;
	private Integer duration;
	private Boolean isActive;

}
