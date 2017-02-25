package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StudentProjectSprintService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.StudentProjectSprint;

@RestController
@RequestMapping("/students/project/sprint")
public class StudentProjectSprintController {

	private static Logger logger = Logger.getLogger(StudentProjectSprintController.class);

	@Autowired
	private StudentProjectSprintService studentProjectSprintService;

	@GetMapping("/list/all")
	public List<StudentProjectSprint> getStudentProjectSprintController() {
		List<StudentProjectSprint> studentProjectsSprint = null;
		try {
			logger.info("Getting the StudentProjectsSprint data...");
			studentProjectsSprint = studentProjectSprintService.getAllStudentProjectSprints();
			logger.info("StudentProjectSprint data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProjectsSprint;
	}

	@GetMapping("/list/id/{id}")
	public List<StudentProjectSprint> getStudentProjectSprintByIdController(@PathVariable Integer id) {
		List<StudentProjectSprint> studentProjectsSprintById = null;
		try {
			logger.info("Getting the StudentProjectsSprint by id...");
			studentProjectsSprintById = studentProjectSprintService.getStudentProjectSprintsById(id);
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
	public List<StudentProjectSprint> getStudentProjectSprintsByStudentProjectIdController(
			@PathVariable("id") Integer studentProjectId) {
		List<StudentProjectSprint> studentProjectsByStudentProjectId = null;
		try {
			logger.info("Getting the StudentProjectSprint by Studentproject id... ");
			studentProjectsByStudentProjectId = studentProjectSprintService
					.getStudentProjectSprintsByStudentProjectId(studentProjectId);
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

	@GetMapping("/list/student/project/sprint/id/{id}")
	public List<StudentProjectSprint> getStudentProjectSprintsByProjectSprintIdController(
			@PathVariable("id") Integer projectSprintId) {
		List<StudentProjectSprint> getStudentProjectSprintsByProjectSprintId = null;
		try {
			logger.info("Getting the StudentProjectSprint by ProjectSprint id... ");
			getStudentProjectSprintsByProjectSprintId = studentProjectSprintService
					.getStudentProjectSprintsByProjectSprintId(projectSprintId);
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
