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
import com.revature.model.dto.CourseContentDTO;

@RestController
@RequestMapping("/course/contents")
public class CourseContentController {

	private static Logger logger = Logger.getLogger(CourseContentController.class);

	@Autowired
	private CourseContentService courseContentService;

	@GetMapping("/list/all")
	public List<CourseContentDTO> getActiveCategoriesController() {
		List<CourseContentDTO> courseContents = null;
		try {
			logger.info("Getting the corse content data...");
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

	@GetMapping("/list/{id}")
	public CourseContentDTO getActiveCategoriesByIdController(@PathVariable("id") Integer id) {
		CourseContentDTO courseContentById = null;
		CourseContentDTO courseContentDTO = new CourseContentDTO();
		courseContentDTO.setId(id);
		try {
			logger.info("Getting the student course by id data...");
			courseContentById = courseContentService.getCourseContentById(courseContentDTO);
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

	@GetMapping("/list/course/{id}")
	public List<CourseContentDTO> getActiveCategoriesByCourseIdController(@PathVariable("id") Integer courseId) {
		List<CourseContentDTO> courseContentById = null;
		CourseContentDTO courseContentDTO = new CourseContentDTO();
		courseContentDTO.setCourseId(courseId);
		try {
			logger.info("Getting the course id by course id data...");
			courseContentById = courseContentService.getCourseContentByCourseId(courseContentDTO);
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

	@GetMapping("/list/video/{id}")
	public CourseContentDTO getActiveCategoriesByVideoController(@PathVariable("id") Integer videoId) {
		CourseContentDTO courseContentById = null;
		CourseContentDTO courseContentDTO = new CourseContentDTO();
		courseContentDTO.setVideoId(videoId);
				try {
			logger.info("Getting the categories by video id data...");
			courseContentById = courseContentService.getCourseContentByVideoId(courseContentDTO);
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
