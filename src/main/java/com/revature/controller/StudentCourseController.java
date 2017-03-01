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
import com.revature.model.StudentCourse;

@RestController
@RequestMapping("/students/courses")
public class StudentCourseController {

	private static Logger logger = Logger.getLogger(StudentCourseController.class);

	@Autowired
	private StudentCourseService studentCourseService;
	

	@GetMapping("/list/all")
	public List<StudentCourse> getStudentCourseController() {
		List<StudentCourse> studentCourses = null;
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
	@GetMapping("/completed/student/course/count/studentId/{studentId}/courseId/{courseId}")
	public List<StudentCourse> getCompletedStudentCourseCountController(@PathVariable("studentId") Integer studentId,@PathVariable("courseId") Integer courseId) {
		List<StudentCourse> completedStudentCourseCount = null;
		try {
			logger.info("Getting the Completed Student Course Count data...");
			completedStudentCourseCount = studentCourseService.getCompletedStudentCourseCount(studentId,courseId);
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
