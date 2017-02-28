package com.revature.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Course;

@Repository
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

}
