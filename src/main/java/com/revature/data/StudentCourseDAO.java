package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourse;

public interface StudentCourseDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentCourse> getAllStudentCourses() throws DataServiceException;

	public List<StudentCourse> getStudentCourseById(int studentCourseId) throws DataServiceException;

	public List<StudentCourse> getStudentCourseByStudentId(int studentId) throws DataServiceException;

	public List<StudentCourse> getStudentCourseByCourseId(int courseId) throws DataServiceException;

}
