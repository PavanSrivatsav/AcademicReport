package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentCourseContent;

public interface StudentCourseContentService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<StudentCourseContent> getAllStudentCourseContents() throws BusinessServiceException;

	List<StudentCourseContent> getAllStudentCourseContentByCourseContentId(int courseContentId)
			throws BusinessServiceException;

	List<StudentCourseContent> getAllStudentCourseContentByStudentCourseId(int studentCourseId)
			throws BusinessServiceException;

}
