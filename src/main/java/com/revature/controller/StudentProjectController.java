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
import com.revature.model.dto.StudentProjectDTO;

@RestController
@RequestMapping("/students/project")
public class StudentProjectController {

	private static Logger logger = Logger.getLogger(StudentProjectController.class);

	@Autowired
	private StudentProjectService studentProjectService;

	@GetMapping("/list/all")
	public List<StudentProjectDTO> getStudentProjectController() {
		List<StudentProjectDTO> studentProjectS = null;
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
	public StudentProjectDTO getStudentProjectByIdController(@PathVariable("id") Integer id) {
		StudentProjectDTO studentProjectsById = null;
		StudentProjectDTO studentProjectDTO=new StudentProjectDTO();
		studentProjectDTO.setId(id);
		try {
			logger.info("Getting the StudentProjects by id...");
			studentProjectsById = studentProjectService.getStudentProjectById(studentProjectDTO);
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
	public List<StudentProjectDTO> getStudentProjectByStudentIdController(@PathVariable("id") Integer studentId) {
		List<StudentProjectDTO> studentProjectsByStudentId = null;
		StudentProjectDTO studentProjectDTO=new StudentProjectDTO();
		studentProjectDTO.setStudentId(studentId);
		try {
			logger.info("Getting the StudentProject by Student id... ");
			studentProjectsByStudentId = studentProjectService.getStudentProjectByStudentId(studentProjectDTO);
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
	public List<StudentProjectDTO> getStudentProjectByProjectIdController(@PathVariable("id") Integer projectId) {
		List<StudentProjectDTO> studentProjectsByProjectId = null;
		StudentProjectDTO studentProjectDTO=new StudentProjectDTO();
		studentProjectDTO.setProjectId(projectId);
		try {
			logger.info("Getting the StudentProject by Project id... ");
			studentProjectsByProjectId = studentProjectService.getStudentProjectByProjectId(studentProjectDTO);
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
	public StudentProjectDTO getCompletedStudentProjectCountController(@PathVariable("studentId") Integer studentId) {
		StudentProjectDTO completedStudentProjectCount = null;
		StudentProjectDTO studentProjectDTO=new StudentProjectDTO();
		studentProjectDTO.setStudentId(studentId);
		try {
			logger.info("Getting the Completed Student Project Count... ");
			completedStudentProjectCount = studentProjectService.getCompletedStudentProjectCount(studentProjectDTO);
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
