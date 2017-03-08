package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProjectDTO {
	private Integer id;
	private String name;
	private Integer categoyId;
	private String description;
	private Integer duration;
	private Boolean isActive;
	private String sprintName;
	private String onlineActivity;
	private String offlineActivity;
	private String quizName;
	private String videoName;
	private String url;
	private String courseName;
	private Integer cunt;
	   public void setProjectCnt(Object o) {
	       if (o != null) {
	           this.cunt = Integer.parseInt(o.toString());

	       }
	   }
	   public Object getProjectCnt() {
	       return 0;
	   }

}
