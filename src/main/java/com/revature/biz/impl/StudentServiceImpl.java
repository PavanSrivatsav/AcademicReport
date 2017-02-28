package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	private static Logger logger = Logger.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<Student> getAllStudents() throws BusinessServiceException {
		List<Student> students = null;
		try {
			students = studentDAO.getAllStudents();
			logger.info("Student retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return students;
	}

	@Override
	public List<Student> getStudentById(int studentId) throws BusinessServiceException {
		return null;
	}

	@Override
	public List<Student> getStudentByEmailId(String studentEmailId) throws BusinessServiceException {
		return null;
	}
	@Override
	public List<Student> getIndividualStudentByCourses(Integer collegeId,Integer departmentId,Integer studentId) throws BusinessServiceException {
		List<Student> individualStudentByCourses = null;
		try {
			individualStudentByCourses = studentDAO.getIndividualStudentByCourses(collegeId,departmentId,studentId);
			logger.info("Individual Student By Courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return individualStudentByCourses;
	}
	@Override
	public List<Student> getIndividualStudentByProjects(Integer collegeId,Integer departmentId,Integer studentId) throws BusinessServiceException {
		List<Student> individualStudentByProjects = null;
		try {
			individualStudentByProjects = studentDAO.getIndividualStudentByProjects(collegeId,departmentId,studentId);
			logger.info("Individual Student By Projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return individualStudentByProjects;
	}
}
