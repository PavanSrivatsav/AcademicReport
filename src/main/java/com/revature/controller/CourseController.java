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
import com.revature.model.dto.CollegeDTO;
import com.revature.model.dto.CourseDTO;

@RestController
@RequestMapping("/courses")
public class CourseController {

	private static Logger logger = Logger.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	
@GetMapping("/list/all")

	public List<CourseDTO> getActiveCoursesController() {

		List<CourseDTO> course = null;

		try {
			logger.info("Getting the courses data...");
			course = courseService.getAllCourses();
			logger.info("courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return course;
	}

	@GetMapping("/list/{id}")
	public CourseDTO getActiveCategoriesController(@PathVariable("id") Integer courseId) {
		CourseDTO course = null;
		CourseDTO courseDTO= new CourseDTO();
		courseDTO.setId(courseId);
		try {
			logger.info("Getting the categories data...");
			course = courseService.getCoursesById(courseDTO);
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
	public CourseDTO getActiveCategoriesByNameController(@PathVariable("name") String courseName) {
		CourseDTO course = null;
		CourseDTO courseDTO=new CourseDTO();
		courseDTO.setName(courseName);
		try {
			logger.info("Getting the categories data...");
			course = courseService.getCourseByName(courseDTO);
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

	@GetMapping("/list/category/{id}")
	public List<CourseDTO> getActiveCategoriesByCategoryIdController(@PathVariable("id") Integer categoryId) {
		List<CourseDTO> course = null;
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setCategoryId(categoryId);
		try {
			logger.info("Getting the categories by category id data...");
			course = courseService.getCourseByCategoryId(courseDTO);
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
	@GetMapping("/list/course/overall/detail/college/{collegeId}")
	public List<CollegeDTO> getCourseOverAllDetailController(@PathVariable("collegeId") Integer collegeId) {
		List<CollegeDTO> courseOverAllDetail = null;
		CollegeDTO collegeDTO= new CollegeDTO();
		collegeDTO.setId(collegeId);
		try {
			logger.info("Getting the over all course details data...");
			courseOverAllDetail = courseService.getCourseOverAllDetail(collegeDTO);
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

	@GetMapping("/list/course/detail/course/{courseId}")
	public List<CourseDTO> getCourseDetailController(@PathVariable("courseId") Integer courseId) {
		List<CourseDTO> courseDetail = null;
		CourseDTO courseDTO= new CourseDTO();
		courseDTO.setId(courseId);
		try {
			logger.info("Getting the course details data...");
			courseDetail = courseService.getCourseDetail(courseDTO);
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

	
	@GetMapping("/total/course/count/course/{courseId}")
	public List<CourseDTO> getTotalCourseCountController(@PathVariable("courseId") Integer courseId) {
		List<CourseDTO> totalCourseCount = null;
		CourseDTO courseDTO= new CourseDTO();
		courseDTO.setId(courseId);
		try {
			logger.info("Getting the Total Course Count data...");
			totalCourseCount = courseService.getTotalCourseCount(courseDTO);
			logger.info("Total Course Count data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return totalCourseCount;
	}
}
