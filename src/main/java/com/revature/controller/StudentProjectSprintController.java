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
import com.revature.model.dto.StudentProjectSprintDTO;

@RestController
@RequestMapping("/students/project/sprint")
public class StudentProjectSprintController {

	private static Logger logger = Logger.getLogger(StudentProjectSprintController.class);

	@Autowired
	private StudentProjectSprintService studentProjectSprintService;

	@GetMapping("/list/all")
	public List<StudentProjectSprintDTO> getStudentProjectSprintController() {
		List<StudentProjectSprintDTO> studentProjectsSprint = null;
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
	public List<StudentProjectSprintDTO> getStudentProjectSprintByIdController(@PathVariable("id") Integer id) {
		List<StudentProjectSprintDTO> studentProjectsSprintById = null;
		StudentProjectSprintDTO studentProjectSprintDTO=new StudentProjectSprintDTO();
		studentProjectSprintDTO.setId(id);
		try {
			logger.info("Getting the StudentProjectsSprint by id...");
			studentProjectsSprintById = studentProjectSprintService.getStudentProjectSprintsById(studentProjectSprintDTO);
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
	public List<StudentProjectSprintDTO> getStudentProjectSprintsByStudentProjectIdController(
			@PathVariable("id") Integer studentProjectId) {
		List<StudentProjectSprintDTO> studentProjectsByStudentProjectId = null;
		StudentProjectSprintDTO studentProjectSprintDTO=new StudentProjectSprintDTO();
		studentProjectSprintDTO.setStudentProjectId(studentProjectId);
		try {
			logger.info("Getting the StudentProjectSprint by Studentproject id... ");
			studentProjectsByStudentProjectId = studentProjectSprintService
					.getStudentProjectSprintsByStudentProjectId(studentProjectSprintDTO);
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
	public List<StudentProjectSprintDTO> getStudentProjectSprintsByProjectSprintIdController(
			@PathVariable("id") Integer projectSprintId) {
		List<StudentProjectSprintDTO> getStudentProjectSprintsByProjectSprintId = null;
		StudentProjectSprintDTO studentProjectSprintDTO=new StudentProjectSprintDTO();
		studentProjectSprintDTO.setProjectSprintId(projectSprintId);
		try {
			logger.info("Getting the StudentProjectSprint by ProjectSprint id... ");
			getStudentProjectSprintsByProjectSprintId = studentProjectSprintService
					.getStudentProjectSprintsByProjectSprintId(studentProjectSprintDTO);
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
