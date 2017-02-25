package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentProjectSprintService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentProjectSprintDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProjectSprint;

@Service
public class StudentProjectSprintServiceImpl implements StudentProjectSprintService {
	private static Logger logger = Logger.getLogger(StudentProjectSprintServiceImpl.class);

	@Autowired
	private StudentProjectSprintDAO studentProjectSprintDAO;

	@Override
	public List<StudentProjectSprint> getAllStudentProjectSprints() throws BusinessServiceException {
		List<StudentProjectSprint> studentProjectSprint = null;
		try {
			studentProjectSprint = studentProjectSprintDAO.getAllStudentProjectSprints();
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprint;
	}

	@Override
	public List<StudentProjectSprint> getStudentProjectSprintsById(Integer Id) throws BusinessServiceException {
		List<StudentProjectSprint> studentProjectSprintId = null;
		try {
			studentProjectSprintId = studentProjectSprintDAO.getStudentProjectSprintsById(Id);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprintId;
	}

	@Override
	public List<StudentProjectSprint> getStudentProjectSprintsByStudentProjectId(Integer studentProjectId)
			throws BusinessServiceException {
		List<StudentProjectSprint> studentProjectSprintsByStudentProjectId = null;
		try {
			studentProjectSprintsByStudentProjectId = studentProjectSprintDAO
					.getStudentProjectSprintsByStudentProjectId(studentProjectId);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprintsByStudentProjectId;
	}

	@Override
	public List<StudentProjectSprint> getStudentProjectSprintsByProjectSprintId(Integer studentProjectSprintId)
			throws BusinessServiceException {
		List<StudentProjectSprint> studentProjectSprintsByProjectSprintId = null;
		try {
			studentProjectSprintsByProjectSprintId = studentProjectSprintDAO
					.getStudentProjectSprintsByProjectSprintId(studentProjectSprintId);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprintsByProjectSprintId;
	}

}
