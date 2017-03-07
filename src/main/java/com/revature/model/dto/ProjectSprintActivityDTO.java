package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProjectSprintActivityDTO {
	private Integer id;
	private Integer projectSprintId;
	private Integer videoId;
	private Integer courseId;
	private Integer quizId;
	private String onlineActivity;
	private String offlineActivity;
	private Integer duration;
	private Boolean isActive;

}
