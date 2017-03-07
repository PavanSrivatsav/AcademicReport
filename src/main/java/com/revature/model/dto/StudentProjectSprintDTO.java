package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StudentProjectSprintDTO {
	private Integer id;
	private Integer studentProjectId;
	private Integer projectSprintId;
	private Date startedOn;
	private Date completedOn;
	private Integer statusId;

}
