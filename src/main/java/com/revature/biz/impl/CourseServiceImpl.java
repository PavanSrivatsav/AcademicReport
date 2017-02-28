package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.CourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CourseDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	private static Logger logger = Logger.getLogger(CourseServiceImpl.class);

	@Autowired
	private CourseDAO courseDAO;

	
	@Override
	public List<Course> getAllCourses() throws BusinessServiceException {
		try {
			logger.info("Courses retrieved successfully");
			return  courseDAO.getAllCourses();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Course> getCoursesById(Integer id) throws BusinessServiceException {
		List<Course> coursesById = null;
		try {
			coursesById = courseDAO.getCourseById(id);
			logger.info("Courses by id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return coursesById;
		
	}

	@Override
	public List<Course> getCourseByName(String courseName) throws BusinessServiceException {
		List<Course> coursesByName = null;
		try {
			coursesByName = courseDAO.getCourseByName(courseName);
			logger.info("Courses by name retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return coursesByName;
	}

	@Override
	public List<Course> getCourseByCategoryId(Integer categoryId) throws BusinessServiceException {
		List<Course> coursesByCategoryId = null;
		try {
			coursesByCategoryId = courseDAO.getCourseByCategoryId(categoryId);
			logger.info("Courses by category id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return coursesByCategoryId;
	}
	@Override
	public List<Course> getCourseOverAllDetail(Integer collegeId) throws BusinessServiceException {
		List<Course> courseOverAllDetail = null;
		try {
			courseOverAllDetail = courseDAO.getCourseOverAllDetail(collegeId);
			logger.info("Courses over all data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courseOverAllDetail;
	}
	@Override
	public List<Course> getCourseDetail(Integer courseId) throws BusinessServiceException {
		List<Course> courseDetail = null;
		try {
			courseDetail = courseDAO.getCourseDetail(courseId);
			logger.info("Course data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courseDetail;
	}

}
