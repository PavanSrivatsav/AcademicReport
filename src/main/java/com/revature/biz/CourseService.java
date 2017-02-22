package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Course;

public interface CourseService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<Course> getAllCourses() throws BusinessServiceException;
}
