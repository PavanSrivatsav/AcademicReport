package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentCourseContentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentCourseContentDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourseContent;

@Service
public class StudentCourseContentServiceImpl implements StudentCourseContentService{
	private static Logger logger = Logger.getLogger(StudentCourseServiceImpl.class);

	@Autowired
	private StudentCourseContentDAO studentCourseContentDAO;

	@Override
	public List<StudentCourseContent> getAllStudentCourseContents() throws BusinessServiceException {
		List<StudentCourseContent> studentCourseContents = null;
		try {
			studentCourseContents = studentCourseContentDAO.getAllStudentCourseContents();
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourseContents;
	}

	@Override
	public List<StudentCourseContent> getAllStudentCourseContentByCourseContentId(int courseContentId)
			throws BusinessServiceException {
		List<StudentCourseContent> studentCourseContent = null;
		try {
			studentCourseContent = studentCourseContentDAO.getStudentCourseContentsByCourseContentId(courseContentId);
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourseContent;
	}

	@Override
	public List<StudentCourseContent> getAllStudentCourseContentByStudentCourseId(int studentCourseId)
			throws BusinessServiceException {
		List<StudentCourseContent> studentCourseContent = null;
		try {
			studentCourseContent = studentCourseContentDAO.getStudentCourseContentsByStudentCourseId(studentCourseId);
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourseContent;
	}

}
