package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.ProjectSprintActivityService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.dto.ProjectSprintActivityDTO;

@RestController
@RequestMapping("/project/sprint/activities")
public class ProjectSprintActivityController {

	private static Logger logger = Logger.getLogger(ProjectSprintActivityController.class);

	@Autowired
	private ProjectSprintActivityService projectSprintActivityService;

	@GetMapping("list/all")
	public List<ProjectSprintActivityDTO> getProjectSprintActivityController() {
		List<ProjectSprintActivityDTO> projectSprintActivities = null;
		try {
			logger.info("Getting the projectSprintActivities data...");
			projectSprintActivities = projectSprintActivityService.getAllProjectSprintActivities();
			logger.info("ProjectSprintActivities data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projectSprintActivities;
	}
	
	
	@GetMapping("/list/{id}")
	public ProjectSprintActivityDTO getActiveCategoriesByIdController(@PathVariable("id") Integer id) {
		ProjectSprintActivityDTO projectSprintActivityById = null;
		ProjectSprintActivityDTO projectSprintActivityDTO = new ProjectSprintActivityDTO();
		projectSprintActivityDTO.setId(id);
		try {
			logger.info("Getting the categories by id data...");
			projectSprintActivityById = projectSprintActivityService.getProjectSprintActivityById(projectSprintActivityDTO);
			logger.info("project sprint activity data by id retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projectSprintActivityById;
	}
}
