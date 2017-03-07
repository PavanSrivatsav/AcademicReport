package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CourseContentDTO {
	private Integer id;
	private Integer courseId;
	private Integer videoId;
	private String textContent;
	private Boolean isActive;

}
