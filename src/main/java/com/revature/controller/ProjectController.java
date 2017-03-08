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
import com.revature.model.Category;
import com.revature.model.dto.CollegeDTO;
import com.revature.model.dto.ProjectDTO;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	private static Logger logger = Logger.getLogger(ProjectController.class);

	@Autowired
	private ProjectService projectService;

	@GetMapping("/list/all")
	public List<ProjectDTO> getProjectController() {
		List<ProjectDTO> projects = null;
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
	public ProjectDTO getActiveProjectsByIdController(@PathVariable("id") Integer projectId) {
		ProjectDTO projectById = null;
		ProjectDTO projectDTO=new ProjectDTO();
		projectDTO.setId(projectId);
		try {
			logger.info("Getting the Projects by id data...");
			projectById = projectService.getProjectById(projectDTO);
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
	public ProjectDTO getActiveProjectsByNameController(@PathVariable("name") String projectName) {
		ProjectDTO projectByName = null;
		ProjectDTO projectDTO=new ProjectDTO();
		projectDTO.setName(projectName);
		try {
			logger.info("Getting the Projects by name data...");
			projectByName = projectService.getProjectByName(projectDTO);
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
	public List<ProjectDTO> getActiveProjectsByCategoryIdController(@PathVariable("id") Integer categoryId) {
		List<ProjectDTO> projectByCategoryId = null;
		ProjectDTO projectDTO=new ProjectDTO();
		Category category=new Category();
		category.setId(categoryId);
		projectDTO.setCategoyId(categoryId);;
		try {
			logger.info("Getting the Projects by category id data...");
			projectByCategoryId = projectService.getProjectByCategoryId(projectDTO);
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
	@GetMapping("/list/project/overall/detail/college/{id}")
	public List<ProjectDTO> getProjectOverAllDetailController(@PathVariable("id") Integer collegeId) {
		List<ProjectDTO> projectOverAllDetail = null;
		CollegeDTO collegeDTO=new CollegeDTO();
		collegeDTO.setId(collegeId);
		try {
			logger.info("Getting the over all project details data...");
			projectOverAllDetail = projectService.getProjectOverAllDetail(collegeDTO);
			logger.info("Over all project details data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projectOverAllDetail;
	}

	@GetMapping("/list/project/detail/project/{id}")
	public List<ProjectDTO> getProjectDetailController(@PathVariable("id") Integer projectId) {
		List<ProjectDTO> projectDetail = null;
		ProjectDTO projectDTO=new ProjectDTO();
		projectDTO.setId(projectId);
		try {
			logger.info("Getting the project details data...");
			projectDetail = projectService.getProjectDetail(projectDTO);
			logger.info("Project details data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projectDetail;
	}
	@GetMapping("/total/project/count/project/{id}")
	public List<ProjectDTO> getTotalProjectCountController(@PathVariable("id") Integer projectId) {
		List<ProjectDTO> totalProjectCount = null;
		ProjectDTO projectDTO=new ProjectDTO();
		projectDTO.setId(projectId);
		try {
			logger.info("Getting the Total Project Count data...");
			totalProjectCount = projectService.getTotalProjectCount(projectDTO);
			logger.info("Total Project Count data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return totalProjectCount;
	}

}
