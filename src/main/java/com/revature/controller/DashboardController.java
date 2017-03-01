package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.DashboardService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.StudentCourse;
import com.revature.model.StudentProject;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	private static Logger logger = Logger.getLogger(DashboardController.class);

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/activecourse/collegeId/{collegeId}/departmentId/{departmentId}")
	public List<StudentCourse> getActiveCoursesController(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId) {
		List<StudentCourse> activeCourse = null;
		try {
			logger.info("Getting the active course data...");
			activeCourse = dashboardService.getActiveCourses(collegeId, departmentId);
			logger.info("Active course data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return activeCourse;
	}

	@GetMapping("/activeproject/collegeId/{collegeId}/departmentId/{departmentId}")
	public List<StudentProject> getActiveProjectsController(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId) {
		List<StudentProject> activeProjects = null;
		try {
			logger.info("Getting the active projects data...");
			activeProjects = dashboardService.getActiveProjects(collegeId, departmentId);
			logger.info("Active projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return activeProjects;
	}

	@GetMapping("/trendingcourse/collegeId/{collegeId}")
	public List<StudentCourse> getTrendingCoursesController(@PathVariable("collegeId") int collegeId) {
		List<StudentCourse> trendingCourse = null;
		try {
			logger.info("Getting the trending course data...");
			trendingCourse = dashboardService.getTrendingCourses(collegeId);
			logger.info("Trending course data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return trendingCourse;
	}

	@GetMapping("/trendingproject/collegeId/{collegeId}")
	public List<StudentProject> getTrendingProjectsController(@PathVariable("collegeId") int collegeId) {
		List<StudentProject> trendingProject = null;
		try {
			logger.info("Getting the trending projects data...");
			trendingProject = dashboardService.getTrendingProjects(collegeId);
			logger.info("Trending project data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return trendingProject;
	}
}
