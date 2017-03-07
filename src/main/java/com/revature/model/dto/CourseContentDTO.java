package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.revature.model.Course;
import com.revature.model.Video;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CourseContentDTO {
	private Integer id;
	private Course course;
	private Video video;
	private String textContent;
	private Boolean isActive;

}
