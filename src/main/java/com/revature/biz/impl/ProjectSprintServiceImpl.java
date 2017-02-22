package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.ProjectSprintService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.ProjectSprintDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.ProjectSprint;

@Service
public class ProjectSprintServiceImpl implements ProjectSprintService {
	private static Logger logger = Logger.getLogger(ProjectSprintServiceImpl.class);

	@Autowired
	private ProjectSprintDAO projectSprintDAO;

	@Override
	public List<ProjectSprint> getAllProjectSprints() throws BusinessServiceException {
		List<ProjectSprint> projectSprints = null;
		try {
			projectSprints = projectSprintDAO.getAllProjectSprints();
			logger.info("ProjectSprint retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectSprints;
	}
}
