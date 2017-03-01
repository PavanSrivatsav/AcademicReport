package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentProjectDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProject;

@Service
public class StudentProjectServiceImpl implements StudentProjectService {
	private static Logger logger = Logger.getLogger(StudentProjectServiceImpl.class);

	@Autowired
	private StudentProjectDAO studentProjectDAO;

	@Override
	public List<StudentProject> getAllStudentProjects() throws BusinessServiceException {
		List<StudentProject> studentProjects = null;
		try {
			studentProjects = studentProjectDAO.getAllStudentProjects();
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjects;
	}

	@Override
	public List<StudentProject> getStudentProjectById(int studentProjectId) throws BusinessServiceException {
		List<StudentProject> studentProject = null;
		try {
			studentProject = studentProjectDAO.getStudentProjectById(studentProjectId);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProject;
	}

	@Override
	public List<StudentProject> getStudentProjectByStudentId(int studentId) throws BusinessServiceException {
		List<StudentProject> studentProjects = null;
		try {
			studentProjects = studentProjectDAO.getStudentProjectByStudentId(studentId);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjects;
	}

	@Override
	public List<StudentProject> getStudentProjectByProjectId(int projectId) throws BusinessServiceException {
		List<StudentProject> studentProjects = null;
		try {
			studentProjects = studentProjectDAO.getStudentProjectByProjectId(projectId);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjects;

	}

	@Override
	public List<StudentProject> getCompletedStudentProjectCount(int studentId) throws BusinessServiceException {
		List<StudentProject> completedStudentProjectCount = null;
		try {
			completedStudentProjectCount = studentProjectDAO.getCompletedStudentProjectCount(studentId);
			logger.info("Completed Student Project Count retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return completedStudentProjectCount;

	}

}
