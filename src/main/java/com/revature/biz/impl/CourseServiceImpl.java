package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.CourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CourseDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Category;
import com.revature.model.College;
import com.revature.model.Course;
import com.revature.model.dto.CollegeDTO;
import com.revature.model.dto.CourseDTO;


@Service
public class CourseServiceImpl implements CourseService {

	private static Logger logger = Logger.getLogger(CourseServiceImpl.class);

@Autowired
	private CourseDAO courseDAO;
	
	@Override
	public List<CourseDTO> getAllCourses() throws BusinessServiceException {
		List<CourseDTO> courses = null;
		try {
			courses = courseDAO.getAllCourses();
			logger.info("Courses retrieved successfully");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courses;
	}


	@Override
	public CourseDTO getCoursesById(CourseDTO courseDTO) throws BusinessServiceException {
		CourseDTO coursesById = null;
		Course course = new Course();
		course.setId(courseDTO.getId());
		
		try {
			coursesById = courseDAO.getCourseById(course);
			logger.info("Courses by id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return coursesById;

	}

	@Override
	public CourseDTO getCourseByName(CourseDTO courseDTO) throws BusinessServiceException {
		CourseDTO coursesByName = null;
		Course course = new Course();
		course.setName(courseDTO.getName());
			try {
			coursesByName = courseDAO.getCourseByName(course);
			logger.info("Courses by name retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return coursesByName;
	}

	@Override
	public List<CourseDTO> getCourseByCategoryId(CourseDTO courseDTO) throws BusinessServiceException {
		List<CourseDTO> coursesByCategoryId = null;
		Course course = new Course();
		Category category=new Category();
		category.setId(courseDTO.getCategoryId());
		course.setCategory(category);
		
		try {
			coursesByCategoryId = courseDAO.getCourseByCategoryId(course);
			logger.info("Courses by category id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return coursesByCategoryId;
	}

	@Override
	public List<CollegeDTO> getCourseOverAllDetail(CollegeDTO collegeDTO) throws BusinessServiceException {
		List<CollegeDTO> courseOverAllDetail = null;
		College college = new College();
		college.setId(collegeDTO.getId());
		try {
			courseOverAllDetail = courseDAO.getCourseOverAllDetail(college);
			logger.info("Courses over all data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courseOverAllDetail;
	}

	@Override
	public List<CourseDTO> getCourseDetail(CourseDTO courseDTO) throws BusinessServiceException {
		List<CourseDTO> courseDetail = null;
		Course course= new Course();
		course.setId(courseDTO.getId());
		try {
			courseDetail = courseDAO.getCourseDetail(course);
			logger.info("Course data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courseDetail;
	}

	@Override
	public List<CourseDTO> getTotalCourseCount(CourseDTO courseDTO) throws BusinessServiceException {
		List<CourseDTO> totalCourseCount = null;
		Course course= new Course();
		course.setId(courseDTO.getId());
		
		try {
			totalCourseCount = courseDAO.getTotalCourseCount(course);
			logger.info("TotalCourseCount retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return totalCourseCount;
	}

}
