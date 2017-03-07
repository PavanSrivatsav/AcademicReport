package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class VideoDTO {
	private Integer id;
	private String name;
	private String url;
	private String transcriptFilename;
	private Integer duration;
	private Boolean isActive;

}
