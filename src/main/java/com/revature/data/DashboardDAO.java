package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Student;
import com.revature.model.dto.StudentCourseDTO;
import com.revature.model.dto.StudentProjectDTO;

public interface DashboardDAO {
	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentCourseDTO> getActiveCourses(Student student) throws DataServiceException;

	public List<StudentProjectDTO> getActiveProjects(Student student) throws DataServiceException;

	public List<StudentCourseDTO> getTrendingCourses(Student student) throws DataServiceException;

	public List<StudentProjectDTO> getTrendingProjects(Student student) throws DataServiceException;

}
