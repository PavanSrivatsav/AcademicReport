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
	public List<Project> getProjectById(int projectId) throws BusinessServiceException {
		return null;
	}

	@Override
	public List<Project> getProjectByName(String projectName) throws BusinessServiceException {
		return null;
	}
}
