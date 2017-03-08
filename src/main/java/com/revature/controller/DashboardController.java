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
import com.revature.model.dto.StudentCourseDTO;
import com.revature.model.dto.StudentDTO;
import com.revature.model.dto.StudentProjectDTO;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	private static Logger logger = Logger.getLogger(DashboardController.class);

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/activecourse/collegeId/{collegeId}/departmentId/{departmentId}")
	public List<StudentCourseDTO> getActiveCoursesController(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId) {
		List<StudentCourseDTO> activeCourse = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setCollegeId(collegeId);
		studentDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the active course data...");
			activeCourse = dashboardService.getActiveCourses(studentDTO);
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
	public List<StudentProjectDTO> getActiveProjectsController(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId) {
		List<StudentProjectDTO> activeProjects = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setCollegeId(collegeId);
		studentDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the active projects data...");
			activeProjects = dashboardService.getActiveProjects(studentDTO);
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
	public List<StudentCourseDTO> getTrendingCoursesController(@PathVariable("collegeId") int collegeId) {
		List<StudentCourseDTO> trendingCourse = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setCollegeId(collegeId);
		try {
			logger.info("Getting the trending course data...");
			trendingCourse = dashboardService.getTrendingCourses(studentDTO);
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
	public List<StudentProjectDTO> getTrendingProjectsController(@PathVariable("collegeId") int collegeId) {
		List<StudentProjectDTO> trendingProject = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setCollegeId(collegeId);
		try {
			logger.info("Getting the trending projects data...");
			trendingProject = dashboardService.getTrendingProjects(studentDTO);
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
