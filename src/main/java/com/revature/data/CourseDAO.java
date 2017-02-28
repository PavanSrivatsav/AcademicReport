package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Course;

public interface CourseDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<Course> getAllCourses() throws DataServiceException;

	public List<Course> getCourseById(Integer Id) throws DataServiceException;

	public List<Course> getCourseByName(String courseName) throws DataServiceException;

	public List<Course> getCourseByCategoryId(Integer categoryId) throws DataServiceException;
	
	public List<Course> getCourseOverAllDetail(Integer collegeId) throws DataServiceException;
	
	public List<Course> getCourseDetail(Integer courseId) throws DataServiceException;

	public List<Course> getTotalCourseCount(Integer courseId) throws DataServiceException;

}
