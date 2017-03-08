package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentCourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentCourseDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Course;
import com.revature.model.Student;
import com.revature.model.StudentCourse;
import com.revature.model.dto.StudentCourseDTO;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
	private static Logger logger = Logger.getLogger(StudentCourseServiceImpl.class);

	@Autowired
	private StudentCourseDAO studentCourseDAO;

	@Override
	public List<StudentCourseDTO> getAllStudentCourses() throws BusinessServiceException {
		List<StudentCourseDTO> studentCourses = null;
		try {
			studentCourses = studentCourseDAO.getAllStudentCourses();
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}

	@Override
	public StudentCourseDTO getStudentCourseById(StudentCourseDTO studentCourseDTO) throws BusinessServiceException {
		StudentCourseDTO studentCoursesDTO = new StudentCourseDTO();
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setId(studentCourseDTO.getId());
		
		try {
			studentCoursesDTO = studentCourseDAO.getStudentCourseById(studentCourse);
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCoursesDTO;
	}

	@Override
	public List<StudentCourseDTO> getStudentCourseByStudentId(StudentCourseDTO studentCourseDTO) throws BusinessServiceException {
		List<StudentCourseDTO> studentCourses = null;
		StudentCourse studentCourse = new StudentCourse();
		Student student= new Student();
		student.setId(studentCourseDTO.getStudentId());
		studentCourse.setStudent(student);
		
		try {
			studentCourses = studentCourseDAO.getStudentCourseByStudentId(studentCourse);
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourseDTO> getStudentCourseByCourseId(StudentCourseDTO studentCourseDTO) throws BusinessServiceException {
		List<StudentCourseDTO> studentCourses = null;
		StudentCourse studentCourse= new StudentCourse();
		Course course = new Course();
		course.setId(studentCourseDTO.getCourseId());
		studentCourse.setCourse(course);
		try {
			studentCourses = studentCourseDAO.getStudentCourseByCourseId(studentCourse);
			logger.info("StudentCourses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourseDTO> getCompletedStudentCourseCount(StudentCourseDTO studentCourseDTO)
			throws BusinessServiceException {
		List<StudentCourseDTO> completedStudentCourseCount = null;
		StudentCourse studentCourse = new StudentCourse();
		Student student= new Student();
		student.setId(studentCourseDTO.getStudentId());
		studentCourse.setStudent(student);
		Course course = new Course();
		course.setId(studentCourseDTO.getCourseId());
		studentCourse.setCourse(course);
		
		
		try {
			completedStudentCourseCount = studentCourseDAO.getCompletedStudentCourseCount(studentCourse);
			logger.info("Completed Student Course Count retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return completedStudentCourseCount;
	}
}
