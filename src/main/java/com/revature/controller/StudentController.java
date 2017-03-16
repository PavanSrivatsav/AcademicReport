package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StudentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.dto.StudentCourseDTO;
import com.revature.model.dto.StudentDTO;
import com.revature.model.dto.StudentProjectDTO;

@RestController
@RequestMapping("/students")
public class StudentController {

	private static Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@GetMapping("/list/all")
	public List<StudentDTO> getStudentController() {
		List<StudentDTO> students = null;
		try {
			logger.info("Getting the Students data...");
			students = studentService.getAllStudents();
			logger.info("Students data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return students;
	}
	
	@GetMapping("/individual/student/details/collegeId/{collegeId}/departmentId/{departmentId}/studentId/{studentId}")
	public StudentDTO getIndividualStudentDetails(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId, @PathVariable("studentId") int studentId) {
		StudentDTO individualStudentByProjects = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(studentId);
		studentDTO.setCollegeId(collegeId);
		studentDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the Individual Students by Projects data...");
			individualStudentByProjects = studentService.getStudentById(studentDTO);
			logger.info("Individual Student By Projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return individualStudentByProjects;
	}

	@GetMapping("/individual/student/courses/collegeId/{collegeId}/departmentId/{departmentId}/studentId/{studentId}")
	public List<StudentCourseDTO> getIndividualStudentByCourses(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId, @PathVariable("studentId") int studentId) {
		List<StudentCourseDTO> individualStudentByCourses = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(studentId);
		studentDTO.setCollegeId(collegeId);
		studentDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the Students data...");
			individualStudentByCourses = studentService.getStudentCoursesByStudentId(studentDTO);
			logger.info("Individual Student By Courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return individualStudentByCourses;
	}
	
	@GetMapping("/individual/student/projects/collegeId/{collegeId}/departmentId/{departmentId}/studentId/{studentId}")
	public List<StudentProjectDTO> getIndividualStudentByProjects(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId, @PathVariable("studentId") int studentId) {
		List<StudentProjectDTO> individualStudentByProjects = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(studentId);
		studentDTO.setCollegeId(collegeId);
		studentDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the Individual Students by Projects data...");
			individualStudentByProjects = studentService.getStudentProjectsByStudentId(studentDTO);
			logger.info("Individual Student By Projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return individualStudentByProjects;
	}

	
/*	@GetMapping("/overall/student/current/courses/collegeId/{collegeId}/departmentId/{departmentId}")
	public List<StudentDTO> getOverAllStudentByCurrentCourses(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId) {
		List<StudentDTO> overAllStudentByCurrentCourses = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setCollegeId(collegeId);
		studentDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the Over All Student By Current Courses data...");
			overAllStudentByCurrentCourses = studentService.getOverAllStudentByCurrentCourses(studentDTO);
			logger.info("Over All  Student By Current Courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return overAllStudentByCurrentCourses;
	}

	@GetMapping("/overall/student/completed/courses/collegeId/{collegeId}/departmentId/{departmentId}")
	public List<StudentDTO> getOverAllStudentByCompletedCourses(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId) {
		List<StudentDTO> overAllStudentByCompletedCourses = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setCollegeId(collegeId);
		studentDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the Over All Student By Completed Courses data...");
			overAllStudentByCompletedCourses = studentService.getOverAllStudentByCompletedCourses(studentDTO);
			logger.info("Over All Student By Completed Courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return overAllStudentByCompletedCourses;
	}

	@GetMapping("/overall/student/current/projects/collegeId/{collegeId}/departmentId/{departmentId}")
	public List<StudentDTO> getOverAllStudentByCurrentProjects(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId) {
		List<StudentDTO> overAllStudentByCurrentProjects = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setCollegeId(collegeId);
		studentDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the Over All Student By Current Projects data...");
			overAllStudentByCurrentProjects = studentService.getOverAllStudentByCurrentProjects(studentDTO);
			logger.info("Over All  Student By Current Projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return overAllStudentByCurrentProjects;
	}

	@GetMapping("/overall/student/completed/projects/collegeId/{collegeId}/departmentId/{departmentId}")
	public List<StudentDTO> getOverAllStudentByCompletedProjects(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId) {
		List<StudentDTO> overAllStudentByCompletedProjects = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setCollegeId(collegeId);
		studentDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the Over All Student By Completed Projects data...");
			overAllStudentByCompletedProjects = studentService.getOverAllStudentByCompletedProjects(studentDTO);
			logger.info("Over All Student By Completed Projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return overAllStudentByCompletedProjects;
	}
*/
	@GetMapping("/overall/student/college/{collegeId}/departmentId/{departmentId}")
	public List<StudentDTO> getOverAllStudentByCollege(@PathVariable("collegeId") int collegeId,
			@PathVariable("departmentId") int departmentId) {
		List<StudentDTO> overAllStudentByCompletedProjects = null;
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setCollegeId(collegeId);
		studentDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the Over All Student By Completed Projects data...");
			overAllStudentByCompletedProjects = studentService.getAllStudentByCollege(studentDTO);
			logger.info("Over All Student By Completed Projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return overAllStudentByCompletedProjects;
	}

}
