package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourseContent;

public interface StudentCourseContentDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentCourseContent> getAllStudentCourseContents() throws DataServiceException;

	public List<StudentCourseContent> getStudentCourseContentsByCourseContentId(int courseContentId)
			throws DataServiceException;

	public List<StudentCourseContent> getStudentCourseContentsByStudentCourseId(int studentCourseId)
			throws DataServiceException;

}
