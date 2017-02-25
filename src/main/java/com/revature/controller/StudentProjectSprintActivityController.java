package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StudentProjectSprintActivityService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.StudentProjectSprintActivity;

@RestController
@RequestMapping("/students/project/sprint/activity")
public class StudentProjectSprintActivityController {

	private static Logger logger = Logger.getLogger(StudentProjectSprintActivityController.class);

	@Autowired
	private StudentProjectSprintActivityService studentProjectSprintActivityService;

	@GetMapping("/list/all")
	public List<StudentProjectSprintActivity> getStudentProjectSprintActivityController() {
		List<StudentProjectSprintActivity> studentProjectSprintActivities = null;
		try {
			logger.info("Getting the StudentProjectsSprintActivities data...");
			studentProjectSprintActivities = studentProjectSprintActivityService.getAllStudentProjectSprintActivities();
			logger.info("StudentProjectSprint data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProjectSprintActivities;
	}

	@GetMapping("/list/id/{id}")
	public List<StudentProjectSprintActivity> getStudentProjectSprintActivityByIdController(@PathVariable Integer id) {
		List<StudentProjectSprintActivity> studentProjectsSprintById = null;
		try {
			logger.info("Getting the StudentProjectsSprintActivities by id...");
			studentProjectsSprintById = studentProjectSprintActivityService.getStudentProjectSprintActivitiesById(id);
			logger.info("StudentProjectSprint data by id retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProjectsSprintById;
	}

	@GetMapping("/list/student/project/id/{id}")
	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesByStudentProjectIdController(
			@PathVariable("id") Integer projectSprintActivityId) {
		List<StudentProjectSprintActivity> studentProjectsByStudentProjectId = null;
		try {
			logger.info("Getting the StudentProjectsSprintActivities by Studentproject id... ");
			studentProjectsByStudentProjectId = studentProjectSprintActivityService
					.getStudentProjectSprintActivitiesByProjectSprintActivityId(projectSprintActivityId);
			logger.info("Getting the StudentProjectSprint by Studentproject id retrieval success ");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProjectsByStudentProjectId;
	}

	@GetMapping("/list/project/sprint/id/{id}")
	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesByProjectSprintIdController(
			@PathVariable("id") Integer studentProjectSprintId) {
		List<StudentProjectSprintActivity> getStudentProjectSprintsByProjectSprintId = null;
		try {
			logger.info("Getting the StudentProjectsSprintActivities by ProjectSprint id... ");
			getStudentProjectSprintsByProjectSprintId = studentProjectSprintActivityService
					.getStudentProjectSprintActivitiesByStudentProjectSprintId(studentProjectSprintId);
			logger.info("Getting the StudentProjectSprint by ProjectSprint id retrieval success ");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return getStudentProjectSprintsByProjectSprintId;
	}

}
