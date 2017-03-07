package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class StudentProjectSprintActivityDTO {
	private Integer id;
	private Integer studentProjectSprintId;
	private Integer projectSprintActivityId;
	private Date startedOn;
	private Date completedOn;
	private Integer statusId;

}
