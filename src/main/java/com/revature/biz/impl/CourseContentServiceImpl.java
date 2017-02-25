package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.CourseContentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CourseContentDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.CourseContent;

@Service
public class CourseContentServiceImpl implements CourseContentService {

	private static Logger logger = Logger.getLogger(CourseContentServiceImpl.class);

	@Autowired
	private CourseContentDAO courseContentDAO;

	@Override
	public List<CourseContent> getAllCourseContents() throws BusinessServiceException {
		List<CourseContent> courseContents = null;
		try {
			courseContents = courseContentDAO.getAllCourseContents();
			logger.info("Course contents retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courseContents;
	}

	@Override
	public List<CourseContent> getCourseContentById(int id) throws BusinessServiceException {
		return null;
	}

}
