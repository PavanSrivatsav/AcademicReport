package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentProjectSprintService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentProjectSprintDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.ProjectSprint;
import com.revature.model.StudentProject;
import com.revature.model.StudentProjectSprint;
import com.revature.model.dto.StudentProjectSprintDTO;

@Service
public class StudentProjectSprintServiceImpl implements StudentProjectSprintService {
	private static Logger logger = Logger.getLogger(StudentProjectSprintServiceImpl.class);

	@Autowired
	private StudentProjectSprintDAO studentProjectSprintDAO;

	@Override
	public List<StudentProjectSprintDTO> getAllStudentProjectSprints() throws BusinessServiceException {
		List<StudentProjectSprintDTO> studentProjectSprint = null;
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
	public List<StudentProjectSprintDTO> getStudentProjectSprintsById(StudentProjectSprintDTO studentProjectSprintDTO) throws BusinessServiceException {
		List<StudentProjectSprintDTO> studentProjectSprintId = null;
		StudentProjectSprint studentProjectSprint=new StudentProjectSprint();
		studentProjectSprint.setId(studentProjectSprintDTO.getId());
		try {
			studentProjectSprintId = studentProjectSprintDAO.getStudentProjectSprintsById(studentProjectSprint);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprintId;
	}

	@Override
	public List<StudentProjectSprintDTO> getStudentProjectSprintsByStudentProjectId(StudentProjectSprintDTO studentProjectSprintDTO)
			throws BusinessServiceException {
		List<StudentProjectSprintDTO> studentProjectSprintsByStudentProjectId = null;
		StudentProjectSprint studentProjectSprint=new StudentProjectSprint();
		StudentProject studentProject=new StudentProject();
		studentProject.setId(studentProjectSprintDTO.getStudentProjectId());
		studentProjectSprint.setStudentProject(studentProject);
		try {
			studentProjectSprintsByStudentProjectId = studentProjectSprintDAO
					.getStudentProjectSprintsByStudentProjectId(studentProjectSprint);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprintsByStudentProjectId;
	}

	@Override
	public List<StudentProjectSprintDTO> getStudentProjectSprintsByProjectSprintId(StudentProjectSprintDTO studentProjectSprintDTO)
			throws BusinessServiceException {
		List<StudentProjectSprintDTO> studentProjectSprintsByProjectSprintId = null;
		StudentProjectSprint studentProjectSprint=new StudentProjectSprint();
		ProjectSprint projectSprint=new ProjectSprint();
		projectSprint.setId(studentProjectSprintDTO.getProjectSprintId());
		studentProjectSprint.setProjectSprint(projectSprint);
		try {
			studentProjectSprintsByProjectSprintId = studentProjectSprintDAO
					.getStudentProjectSprintsByProjectSprintId(studentProjectSprint);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectSprintsByProjectSprintId;
	}

}
