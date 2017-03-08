package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StudentCourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.dto.StudentCourseDTO;

@RestController
@RequestMapping("/students/courses")
public class StudentCourseController {

	private static Logger logger = Logger.getLogger(StudentCourseController.class);

	@Autowired
	private StudentCourseService studentCourseService;

	@GetMapping("/list/all")
	public List<StudentCourseDTO> getStudentCourseController() {
		List<StudentCourseDTO> studentCourses = null;
		try {
			logger.info("Getting the StudentCourses data...");
			studentCourses = studentCourseService.getAllStudentCourses();
			logger.info("StudentCourses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentCourses;
	}
	
	@GetMapping("/list/{id}")
	public StudentCourseDTO getStudentCourseByIdController(@PathVariable("id") Integer id) {
		StudentCourseDTO studentCourseById  = null;
		StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
		studentCourseDTO.setId(id);
		try {
			logger.info("Getting the student course by id data...");
			studentCourseById = studentCourseService.getStudentCourseById(studentCourseDTO);
			logger.info("student course data by id retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentCourseById;
	}
	
	@GetMapping("/list/student/{id}")
	public List<StudentCourseDTO> getStudentCourseByStudentIdController(@PathVariable("id") Integer studentId) {
		List<StudentCourseDTO> studentCourses = null;
		StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
		studentCourseDTO.setStudentId(studentId);
		try {
			logger.info("Getting the Student Courses data by student id...");
			studentCourses = studentCourseService.getStudentCourseByStudentId(studentCourseDTO);
			logger.info("StudentCourses data  by student id retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentCourses;
	}
	
	@GetMapping("/list/course/{id}")
	public List<StudentCourseDTO> getStudentCourseByCourseIdController(@PathVariable("id") Integer courseId) {
		List<StudentCourseDTO> studentCourses = null;
		StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
		studentCourseDTO.setCourseId(courseId);
		try {
			logger.info("Getting the Student Courses data by course id...");
			studentCourses = studentCourseService.getStudentCourseByCourseId(studentCourseDTO);
			logger.info("Student Courses data  by course id retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentCourses;
	}
	
	
	@GetMapping("/completed/student/course/count/student/{studentId}/course/{courseId}")
	public List<StudentCourseDTO> getCompletedStudentCourseCountController(@PathVariable("studentId") Integer studentId,@PathVariable("courseId") Integer courseId) {
		List<StudentCourseDTO> completedStudentCourseCount = null;
		StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
		studentCourseDTO.setStudentId(studentId);
		studentCourseDTO.setCourseId(courseId);
		try {
			logger.info("Getting the Completed Student Course Count data...");
			completedStudentCourseCount = studentCourseService.getCompletedStudentCourseCount(studentCourseDTO);
			logger.info("Completed Student Course Count data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return completedStudentCourseCount;
	}
}
