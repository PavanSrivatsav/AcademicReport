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

	List<Course> getCoursesById(Integer id) throws BusinessServiceException;

	List<Course> getCourseByName(String courseName) throws BusinessServiceException;

	List<Course> getCourseByCategoryId(Integer categoryId) throws BusinessServiceException;
	
	List<Course> getCourseOverAllDetail(Integer collegeId) throws BusinessServiceException;
	
	List<Course> getCourseDetail(Integer courseId) throws BusinessServiceException;


}
