package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentProjectSprintActivityService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentProjectSprintActivityDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProjectSprintActivity;

@Service
public class StudentProjectSprintActivityServiceImpl implements StudentProjectSprintActivityService {
	private static Logger logger = Logger.getLogger(StudentProjectSprintActivityServiceImpl.class);

	@Autowired
	private StudentProjectSprintActivityDAO studentProjectSprintActivityDAO;

	@Override
	public List<StudentProjectSprintActivity> getAllStudentProjectSprintActivities() throws BusinessServiceException {
		List<StudentProjectSprintActivity> studentProjectSprintActivities = null;
		try {
			studentProjectSprintActivities = studentProjectSprintActivityDAO.getAllStudentProjectSprintActivities();
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprintActivities;
	}

	@Override
	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesById(Integer Id)
			throws BusinessServiceException {
		List<StudentProjectSprintActivity> studentProjectSprintActivitiesById = null;
		try {
			studentProjectSprintActivitiesById = studentProjectSprintActivityDAO
					.getStudentProjectSprintActivitiesById(Id);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprintActivitiesById;
	}

	@Override
	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesByProjectSprintActivityId(
			Integer projectSprintActivityId) throws BusinessServiceException {
		List<StudentProjectSprintActivity> studentProjectSprintActivitiesByProjectSprintActivityId = null;
		try {
			studentProjectSprintActivitiesByProjectSprintActivityId = studentProjectSprintActivityDAO
					.getStudentProjectSprintActivitiesByProjectSprintActivityId(projectSprintActivityId);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprintActivitiesByProjectSprintActivityId;
	}

	@Override
	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesByStudentProjectSprintId(
			Integer studentProjectSprintId) throws BusinessServiceException {
		List<StudentProjectSprintActivity> studentProjectSprintActivitiesByStudentProjectSprintId = null;
		try {
			studentProjectSprintActivitiesByStudentProjectSprintId = studentProjectSprintActivityDAO
					.getStudentProjectSprintActivitiesByStudentProjectSprintId(studentProjectSprintId);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprintActivitiesByStudentProjectSprintId;
	}

}
