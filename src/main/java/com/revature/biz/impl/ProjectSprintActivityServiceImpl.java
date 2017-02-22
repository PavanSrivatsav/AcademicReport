package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.ProjectSprintActivityService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.ProjectSprintActivityDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.ProjectSprintActivity;

@Service
public class ProjectSprintActivityServiceImpl implements ProjectSprintActivityService {
	private static Logger logger = Logger.getLogger(ProjectSprintActivityServiceImpl.class);

	@Autowired
	private ProjectSprintActivityDAO projectSprintActivityDAO;

	@Override
	public List<ProjectSprintActivity> getAllProjectSprintActivities() throws BusinessServiceException {
		List<ProjectSprintActivity> projectSprintActivities = null;
		try {
			projectSprintActivities = projectSprintActivityDAO.getAllProjectSprintActivities();
			logger.info("ProjectSprintActivitys retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projectSprintActivities;
	}
}
