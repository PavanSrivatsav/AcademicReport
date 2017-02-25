package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.CourseContentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.CourseContent;

@RestController
@RequestMapping("/course/contents")
public class CourseContentController {

	private static Logger logger = Logger.getLogger(CourseContentController.class);

	@Autowired
	private CourseContentService courseContentService;

	@GetMapping("/list/all")
	public List<CourseContent> getActiveCategoriesController() {
		List<CourseContent> courseContents = null;
		try {
			logger.info("Getting the categories data...");
			courseContents = courseContentService.getAllCourseContents();
			logger.info("course contents data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return courseContents;
	}

	@GetMapping("/list/id/{id}")
	public List<CourseContent> getActiveCategoriesByIdController(@PathVariable("id") Integer id) {
		List<CourseContent> courseContentById = null;
		try {
			logger.info("Getting the categories by id data...");
			courseContentById = courseContentService.getCourseContentById(id);
			logger.info("category data by id retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return courseContentById;
	}

	@GetMapping("/list/course/id/{id}")
	public List<CourseContent> getActiveCategoriesByCourseIdController(@PathVariable("id") Integer courseId) {
		List<CourseContent> courseContentById = null;
		try {
			logger.info("Getting the categories by course id data...");
			courseContentById = courseContentService.getCourseContentByCourseId(courseId);
			logger.info("Categories by course id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return courseContentById;
	}

	@GetMapping("/list/video/id/{id}")
	public List<CourseContent> getActiveCategoriesByVideoController(@PathVariable("id") Integer videoId) {
		List<CourseContent> courseContentById = null;
		try {
			logger.info("Getting the categories by video id data...");
			courseContentById = courseContentService.getCourseContentByVideoId(videoId);
			logger.info("categories by video id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return courseContentById;
	}

}
