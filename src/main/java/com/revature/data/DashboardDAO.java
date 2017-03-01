package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourse;
import com.revature.model.StudentProject;

public interface DashboardDAO {
	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentCourse> getActiveCourses(Integer collegeId, Integer departmentId) throws DataServiceException;

	public List<StudentProject> getActiveProjects(Integer collegeId, Integer departmentId) throws DataServiceException;

	public List<StudentCourse> getTrendingCourses(Integer collegeId) throws DataServiceException;

	public List<StudentProject> getTrendingProjects(Integer collegeId) throws DataServiceException;

}
