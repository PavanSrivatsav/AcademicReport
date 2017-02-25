package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentCourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentCourseDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourse;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
	private static Logger logger = Logger.getLogger(StudentCourseServiceImpl.class);

	@Autowired
	private StudentCourseDAO studentCourseDAO;

	@Override
	public List<StudentCourse> getAllStudentCourses() throws BusinessServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			studentCourses = studentCourseDAO.getAllStudentCourses();
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourse> getStudentCourseById(int studentCourseId) throws BusinessServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			studentCourses = studentCourseDAO.getStudentCourseById(studentCourseId);
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourse> getStudentCourseByStudentId(int studentId) throws BusinessServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			studentCourses = studentCourseDAO.getStudentCourseByStudentId(studentId);
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourse> getStudentCourseByCourseId(int courseId) throws BusinessServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			studentCourses = studentCourseDAO.getStudentCourseById(courseId);
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}
}
