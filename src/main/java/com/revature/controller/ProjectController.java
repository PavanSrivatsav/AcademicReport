package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.ProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Project;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	private static Logger logger = Logger.getLogger(ProjectController.class);

	@Autowired
	private ProjectService projectService;

	@GetMapping("/list/all")
	public List<Project> getProjectController() {
		List<Project> projects = null;
		try {
			logger.info("Getting the Projects data...");
			projects = projectService.getAllProjects();
			logger.info("Projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projects;
	}

	@GetMapping("/list/id/{id}")
	public List<Project> getActiveProjectsByIdController(@PathVariable("id") Integer id) {
		List<Project> projectById = null;
		try {
			logger.info("Getting the Projects by id data...");
			projectById = projectService.getProjectById(id);
			logger.info("Projects by id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projectById;
	}

	@GetMapping("/list/name/{name}")
	public List<Project> getActiveProjectsByNameController(@PathVariable("name") String name) {
		List<Project> projectByName = null;
		try {
			logger.info("Getting the Projects by name data...");
			projectByName = projectService.getProjectByName(name);
			logger.info("Projects by name data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projectByName;
	}

	@GetMapping("/list/category/id/{id}")
	public List<Project> getActiveProjectsByCategoryIdController(@PathVariable("id") Integer categoryId) {
		List<Project> projectByCategoryId = null;
		try {
			logger.info("Getting the Projects by category id data...");
			projectByCategoryId = projectService.getProjectByCategoryId(categoryId);
			logger.info("Projects by category id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projectByCategoryId;
	}
}
