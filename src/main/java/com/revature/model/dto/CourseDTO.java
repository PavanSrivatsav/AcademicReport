package com.revature.model.dto;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


@Data
@JsonInclude(Include.NON_NULL)
public class CourseDTO {
	private Integer id;

	private String name;
	private Integer categoryId;
	private String description;
	private Integer duration;
	private Boolean isActive;
	private BigInteger count;
	private String cont;
	private String vidname;
	private String url;

	  	   
}
