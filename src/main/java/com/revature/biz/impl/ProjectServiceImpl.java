package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.ProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.ProjectDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Category;
import com.revature.model.College;
import com.revature.model.Project;
import com.revature.model.dto.CollegeDTO;
import com.revature.model.dto.ProjectDTO;

@Service
public class ProjectServiceImpl implements ProjectService {
	private static Logger logger = Logger.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public List<ProjectDTO> getAllProjects() throws BusinessServiceException {
		List<ProjectDTO> projects = null;
		try {
			projects = projectDAO.getAllProjects();
			logger.info("Project retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projects;
	}

	@Override
	public ProjectDTO getProjectById(ProjectDTO projectDTO) throws BusinessServiceException {
		ProjectDTO projectById = new ProjectDTO();
		Project project=new Project();
		project.setId(projectDTO.getId());
		try {
			projectById = projectDAO.getProjectById(project);
			logger.info("Project by id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectById;
	}

	@Override
	public ProjectDTO getProjectByName(ProjectDTO projectDTO) throws BusinessServiceException {
		ProjectDTO projectByName = new ProjectDTO();
		Project project=new Project();
		project.setName(projectDTO.getName());
		try {
			projectByName = projectDAO.getProjectByName(project);
			logger.info("Project by name retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectByName;
	}

	@Override
	public List<ProjectDTO> getProjectByCategoryId(ProjectDTO projectDTO) throws BusinessServiceException {
		List<ProjectDTO> projectByCategoryId = null;
		Project project=new Project();
		Category category=new Category();
		category.setId(projectDTO.getCategoyId());
		project.setCategoy(category);
		try {
			projectByCategoryId = projectDAO.getProjectByCategoryId(project);
			logger.info("Project by category id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectByCategoryId;
	}

	@Override
	public List<ProjectDTO> getProjectOverAllDetail(CollegeDTO collegeDTO) throws BusinessServiceException {
		List<ProjectDTO> projectOverAllDetail = null;
		College college=new College();
		college.setId(collegeDTO.getId());
		try {
			projectOverAllDetail = projectDAO.getProjectOverAllDetail(college);
			logger.info("Projects over all data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectOverAllDetail;
	}

	@Override
	public List<ProjectDTO> getProjectDetail(ProjectDTO projectDTO) throws BusinessServiceException {
		List<ProjectDTO> projectDetail = null;
		Project project=new Project();
		project.setId(projectDTO.getId());
		try {
			projectDetail = projectDAO.getProjectDetail(project);
			logger.info("Project data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectDetail;
	}

	@Override
	public List<ProjectDTO> getTotalProjectCount(ProjectDTO projectDTO) throws BusinessServiceException {
		List<ProjectDTO> totalProjectCount = null;
		Project project=new Project();
		project.setId(projectDTO.getId());
		try {
			totalProjectCount = projectDAO.getTotalProjectCount(project);
			logger.info("Total Project Count data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return totalProjectCount;
	}

}
