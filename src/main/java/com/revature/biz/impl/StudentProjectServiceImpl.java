package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentProjectDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Project;
import com.revature.model.Student;
import com.revature.model.StudentProject;
import com.revature.model.dto.StudentProjectDTO;

@Service
public class StudentProjectServiceImpl implements StudentProjectService {
	private static Logger logger = Logger.getLogger(StudentProjectServiceImpl.class);

	@Autowired
	private StudentProjectDAO studentProjectDAO;

	@Override
	public List<StudentProjectDTO> getAllStudentProjects() throws BusinessServiceException {
		List<StudentProjectDTO> studentProjects = null;
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
	public StudentProjectDTO getStudentProjectById(StudentProjectDTO studentProjectDTO) throws BusinessServiceException {
		StudentProjectDTO studentProjectById = new StudentProjectDTO();
		StudentProject studentProject = new StudentProject();
		studentProject.setId(studentProjectDTO.getId());
		try {
			studentProjectById = studentProjectDAO.getStudentProjectById(studentProject);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentProjectById;
	}

	@Override
	public List<StudentProjectDTO> getStudentProjectByStudentId(StudentProjectDTO studentProjectDTO) throws BusinessServiceException {
		List<StudentProjectDTO> studentById = null;
		StudentProject studentProject = new StudentProject();
		Student student=new Student();
		student.setId(studentProjectDTO.getStudentId());
		studentProject.setStudent(student);
		try {
			studentById = studentProjectDAO.getStudentProjectByStudentId(studentProject);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentById;
	}

	@Override
	public List<StudentProjectDTO> getStudentProjectByProjectId(StudentProjectDTO studentProjectDTO) throws BusinessServiceException {
		List<StudentProjectDTO> ProjectsById = null;
		StudentProject studentProject = new StudentProject();
		Project project=new Project();
		project.setId(studentProjectDTO.getProjectId());
		studentProject.setProject(project);
		try {
			ProjectsById = studentProjectDAO.getStudentProjectByProjectId(studentProject);
			logger.info("StudentProjects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return ProjectsById;

	}

	@Override
	public StudentProjectDTO getCompletedStudentProjectCount(StudentProjectDTO studentProjectDTO) throws BusinessServiceException {
		StudentProjectDTO completedStudentProjectCount = new StudentProjectDTO();
		StudentProject studentProject = new StudentProject();
		Student student=new Student();
		student.setId(studentProjectDTO.getStudentId());
		studentProject.setStudent(student);
		try {
			completedStudentProjectCount = studentProjectDAO.getCompletedStudentProjectCount(studentProject);
			logger.info("Completed Student Project Count retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return completedStudentProjectCount;

	}

}
