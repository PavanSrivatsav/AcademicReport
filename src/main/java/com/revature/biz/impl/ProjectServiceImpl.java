package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.ProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.ProjectDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {
	private static Logger logger = Logger.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public List<Project> getAllProjects() throws BusinessServiceException {
		List<Project> projects = null;
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
	public List<Project> getProjectById(Integer id) throws BusinessServiceException {
		List<Project> projectById = null;
		try {
			projectById = projectDAO.getProjectById(id);
			logger.info("Project by id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectById;
	}

	@Override
	public List<Project> getProjectByName(String projectName) throws BusinessServiceException {
		List<Project> projectByName = null;
		try {
			projectByName = projectDAO.getProjectByName(projectName);
			logger.info("Project by name retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectByName;
	}

	@Override
	public List<Project> getProjectByCategoryId(Integer categoryId) throws BusinessServiceException {
		List<Project> projectByCategoryId = null;
		try {
			projectByCategoryId = projectDAO.getProjectByCategoryId(categoryId);
			logger.info("Project by category id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectByCategoryId;
	}
	@Override
	public List<Project> getProjectOverAllDetail(Integer collegeId) throws BusinessServiceException {
		List<Project> projectOverAllDetail = null;
		try {
			projectOverAllDetail = projectDAO.getProjectOverAllDetail(collegeId);
			logger.info("Projects over all data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectOverAllDetail;
	}
	@Override
	public List<Project> getProjectDetail(Integer projectId) throws BusinessServiceException {
		List<Project> projectDetail = null;
		try {
			projectDetail = projectDAO.getProjectDetail(projectId);
			logger.info("Project data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectDetail;
	}
	
	@Override
	public List<Project> getTotalProjectCount(Integer projectId) throws BusinessServiceException {
		List<Project> totalProjectCount = null;
		try {
			totalProjectCount = projectDAO.getTotalProjectCount(projectId);
			logger.info("Total Project Count data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return totalProjectCount;
	}

}
