package com.revature.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.data.exception.DataServiceException;
import com.revature.model.College;
import com.revature.model.Course;
import com.revature.model.dto.CollegeDTO;
import com.revature.model.dto.CourseDTO;

@Repository
public interface CourseDAO {
	/**
	 * @return
	 * @throws DataServiceException
	 */
	


	public List<CourseDTO> getAllCourses() throws DataServiceException;

	public <E>CourseDTO getCourseById(Course course) throws DataServiceException;

	public <E> CourseDTO getCourseByName(Course course) throws DataServiceException;

	public List<CourseDTO> getCourseByCategoryId(Course course) throws DataServiceException;
	
	public List<CollegeDTO> getCourseOverAllDetail(College college) throws DataServiceException;
	
	public List<CourseDTO> getCourseDetail(Course course) throws DataServiceException;

	public List<CourseDTO> getTotalCourseCount(Course course) throws DataServiceException;

}
