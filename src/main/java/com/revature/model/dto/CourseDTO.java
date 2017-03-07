package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


@Data
@JsonInclude(Include.NON_NULL)
public class CourseDTO {
	private Integer id;
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Integer getCategoryId() {
//		return categoryId;
//	}
//
//	public void setCategoryId(Integer categoryId) {
//		this.categoryId = categoryId;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Integer getDuration() {
//		return duration;
//	}
//
//	public void setDuration(Integer duration) {
//		this.duration = duration;
//	}
//
//	public Boolean getIsActive() {
//		return isActive;
//	}
//
//	public void setIsActive(Boolean isActive) {
//		this.isActive = isActive;
//	}
//
//	public Integer getCunt() {
//		return cunt;
//	}
//
//	public void setCunt(Integer cunt) {
//		this.cunt = cunt;
//	}

	private String name;
	private Integer categoryId;
	private String description;
	private Integer duration;
	private Boolean isActive;
	private Integer cunt;
	private String cont;
	private String vidname;
	private String url;

	/*public void setCourseId(Object o) {
	       if (o != null) {
	           this.id = Integer.parseInt(o.toString());

	       }
	   }

	   public Object getCourseId() {
	       return 0;
	   }
	   */
	   public void setCourseCnt(Object o) {
	       if (o != null) {
	           this.cunt = Integer.parseInt(o.toString());

	       }
	   }
	   public Object getCourseCnt() {
	       return 0;
	   }
	  
	  	   
}
