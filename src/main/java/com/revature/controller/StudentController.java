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
import com.revature.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	private static Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@GetMapping("/List/All")
	public List<Student> getStudentController() {
		List<Student> students = null;
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
	@GetMapping("/IndividualStudentByCourses/collegeId/{collegeId}/departmentId/{departmentId}/studentId/{studentId}")
	public List<Student> getIndividualStudentByCourses(@PathVariable("collegeId") int collegeId,@PathVariable("departmentId") int departmentId,@PathVariable("studentId") int studentId) {
		List<Student> individualStudentByCourses = null;
		try {
			logger.info("Getting the Students data...");
			individualStudentByCourses = studentService.getIndividualStudentByCourses(collegeId,departmentId,studentId);
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
	@GetMapping("/IndividualStudentByProjects/collegeId/{collegeId}/departmentId/{departmentId}/studentId/{studentId}")
	public List<Student> getIndividualStudentByProjects(@PathVariable("collegeId") int collegeId,@PathVariable("departmentId") int departmentId,@PathVariable("studentId") int studentId) {
		List<Student> individualStudentByProjects = null;
		try {
			logger.info("Getting the Individual Students by Projects data...");
			individualStudentByProjects = studentService.getIndividualStudentByProjects(collegeId,departmentId,studentId);
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
}
