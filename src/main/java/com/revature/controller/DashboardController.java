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
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	private static Logger logger = Logger.getLogger(DashboardController.class);

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/list/collegeId/{collegeId}/departmentId/{departmentId}")
	public List<StudentCourse> getActiveCoursesController(@PathVariable("collegeId") int collegeId,@PathVariable("departmentId") int departmentId) {
		List<StudentCourse> activeCourse = null;
		try {
			logger.info("Getting the active course data...");
			activeCourse = dashboardService.getActiveCourses(collegeId,departmentId);
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
}
