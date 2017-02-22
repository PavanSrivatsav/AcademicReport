package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.ProjectSprintService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.ProjectSprint;

@RestController

public class ProjectSprintController {

	private static Logger logger = Logger.getLogger(ProjectSprintController.class);

	@Autowired
	private ProjectSprintService projectSprintService;

	@RequestMapping("/projects/sprints")
	public List<ProjectSprint> getProjectSprintController() {
		List<ProjectSprint> projectSprints = null;
		try {
			logger.info("Getting the ProjectSprints data...");
			projectSprints = projectSprintService.getAllProjectSprints();
			logger.info("Status data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projectSprints;
	}
}
