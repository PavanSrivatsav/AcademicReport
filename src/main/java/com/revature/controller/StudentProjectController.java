package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StudentProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.StudentProject;

@RestController
@RequestMapping("/students/project")
public class StudentProjectController {

	private static Logger logger = Logger.getLogger(StudentProjectController.class);

	@Autowired
	private StudentProjectService studentProjectService;

	@GetMapping("/list/all")
	public List<StudentProject> getStudentProjectController() {
		List<StudentProject> studentProjectS = null;
		try {
			logger.info("Getting the StudentProjects data...");
			studentProjectS = studentProjectService.getAllStudentProjects();
			logger.info("StudentProject data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProjectS;
	}

	@GetMapping("/list/id/{id}")
	public List<StudentProject> getStudentProjectByIdController(@PathVariable Integer id) {
		List<StudentProject> studentProjectsById = null;
		try {
			logger.info("Getting the StudentProjects by id...");
			studentProjectsById = studentProjectService.getStudentProjectById(id);
			logger.info("StudentProject data by id retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProjectsById;
	}

	@GetMapping("/list/student/id/{id}")
	public List<StudentProject> getStudentProjectByStudentIdController(@PathVariable("id") Integer studentId) {
		List<StudentProject> studentProjectsByStudentId = null;
		try {
			logger.info("Getting the StudentProject by Student id... ");
			studentProjectsByStudentId = studentProjectService.getStudentProjectByStudentId(studentId);
			logger.info("Getting the StudentProject by Student id retrieval success ");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProjectsByStudentId;
	}

	@GetMapping("/list/student/project/id/{id}")
	public List<StudentProject> getStudentProjectByProjectIdController(@PathVariable("id") Integer projectId) {
		List<StudentProject> studentProjectsByProjectId = null;
		try {
			logger.info("Getting the StudentProject by Project id... ");
			studentProjectsByProjectId = studentProjectService.getStudentProjectByProjectId(projectId);
			logger.info("Getting the StudentProject by Project id retrieval success ");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProjectsByProjectId;
	}
	
	@GetMapping("/completed/student/project/count/studentId/{studentId}")
	public List<StudentProject> getCompletedStudentProjectCountController(@PathVariable("studentId") Integer studentId) {
		List<StudentProject> completedStudentProjectCount = null;
		try {
			logger.info("Getting the Completed Student Project Count... ");
			completedStudentProjectCount = studentProjectService.getCompletedStudentProjectCount(studentId);
			logger.info("Getting the Completed Student Project Count retrieval success ");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return completedStudentProjectCount;
	}
	
}
