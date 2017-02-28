package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentCourse;

public interface StudentCourseService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<StudentCourse> getAllStudentCourses() throws BusinessServiceException;

	List<StudentCourse> getStudentCourseById(int studentCourseId) throws BusinessServiceException;

	List<StudentCourse> getStudentCourseByStudentId(int studentId) throws BusinessServiceException;

	List<StudentCourse> getStudentCourseByCourseId(int courseId) throws BusinessServiceException;
	
	List<StudentCourse> getCompletedStudentCourseCount(int studentId,int courseId) throws BusinessServiceException;
}
