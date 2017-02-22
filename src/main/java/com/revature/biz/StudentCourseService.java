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
}
