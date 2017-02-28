package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.CourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Course;

@RestController
@RequestMapping("/courses")
public class CourseController {

	private static Logger logger = Logger.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@GetMapping("/list/all")
	
	public List<?> getActiveCoursesController() {
		
		List<Course> list = null;
		
		try {
			logger.info("Getting the courses data...");
			list= courseService.getAllCourses();
			logger.info("courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return list;
	}

	@GetMapping("/list/id/{id}")
	public List<Course> getActiveCategoriesController(@PathVariable("id") int courseId) {
		List<Course> course = null;
		try {
			logger.info("Getting the categories data...");
			course = courseService.getCoursesById(courseId);
			logger.info("course data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return course;
	}

	@GetMapping("/list/name/{name}")
	public List<Course> getActiveCategoriesByNameController(@PathVariable("name") String courseName) {
		List<Course> course = null;
		try {
			logger.info("Getting the categories data...");
			course = courseService.getCourseByName(courseName);
			logger.info("course data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return course;
	}

	@GetMapping("/list/category/id/{id}")
	public List<Course> getActiveCategoriesByCategoryIdController(@PathVariable("id") Integer categoryId) {
		List<Course> course = null;
		try {
			logger.info("Getting the categories by category id data...");
			course = courseService.getCourseByCategoryId(categoryId);
			logger.info("categories by category id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return course;
	}
	@GetMapping("/list/CourseOverAllDetail/collegeId/{collegeId}")
	public List<Course> getCourseOverAllDetailController(@PathVariable("collegeId") Integer collegeId) {
		List<Course> courseOverAllDetail = null;
		try {
			logger.info("Getting the over all course details data...");
			courseOverAllDetail = courseService.getCourseOverAllDetail(collegeId);
			logger.info("Over all course details data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return courseOverAllDetail;
	}
	@GetMapping("/list/CourseDetail/courseId/{courseId}")
	public List<Course> getCourseDetailController(@PathVariable("courseId") Integer courseId) {
		List<Course> courseDetail = null;
		try {
			logger.info("Getting the course details data...");
			courseDetail = courseService.getCourseDetail(courseId);
			logger.info("Course details data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return courseDetail;
	}
}
