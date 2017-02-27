package com.revature.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.revature.biz.CourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CourseRepository;
import com.revature.model.Course;

@Service
@Primary
public class CourseServiceImpl2 implements CourseService {

	private static Logger logger = Logger.getLogger(CourseServiceImpl2.class);

	@Autowired
	private CourseRepository courseDAO;
	
	@Override
	public List<Course> getAllCourses() throws BusinessServiceException {
		try {
			logger.info("Courses retrieved successfully");
			return  courseDAO.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Course> getCoursesById(Integer id) throws BusinessServiceException {
		List<Course> coursesById = new ArrayList<>();
		try {
			Course course = courseDAO.findOne(Long.valueOf(id));
			coursesById.add(course);
			logger.info("Courses by id retrieved successfully");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return coursesById;
	}

	@Override
	public List<Course> getCourseByName(String courseName) throws BusinessServiceException {
		List<Course> coursesByName = null;
		try {
			coursesByName = courseDAO.findByName(courseName);
			logger.info("Courses by name retrieved successfully");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return coursesByName;
	}

	@Override
	public List<Course> getCourseByCategoryId(Integer categoryId) throws BusinessServiceException {
		List<Course> coursesByCategoryId = null;
		try {
			coursesByCategoryId = courseDAO.findByCategory(categoryId);
			logger.info("Courses by category id retrieved successfully");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return coursesByCategoryId;
	}

}
