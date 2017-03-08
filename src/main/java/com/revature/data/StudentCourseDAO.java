package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourse;
import com.revature.model.dto.StudentCourseDTO;

public interface StudentCourseDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentCourseDTO> getAllStudentCourses() throws DataServiceException;

	public <E>StudentCourseDTO getStudentCourseById(StudentCourse studentCourse) throws DataServiceException;

	public List<StudentCourseDTO> getStudentCourseByStudentId(StudentCourse studentCourse) throws DataServiceException;

	public List<StudentCourseDTO> getStudentCourseByCourseId(StudentCourse studentCourse) throws DataServiceException;

	public List<StudentCourseDTO> getCompletedStudentCourseCount(StudentCourse studentCourse) throws DataServiceException;
}
