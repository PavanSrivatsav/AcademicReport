package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentCourse;
import com.revature.model.StudentProject;

public interface DashboardService {

	/**
	 * Used to get all the categories.
	 * 
	 * @return categories
	 * @throws BusinessServiceException
	 *             if any business error occurs
	 */
	List<StudentCourse> getActiveCourses(Integer collegeId,Integer departmentId) throws BusinessServiceException;
	List<StudentProject> getActiveProjects(Integer collegeId,Integer departmentId) throws BusinessServiceException;
	List<StudentCourse> getTrendingCourses(Integer collegeId) throws BusinessServiceException;
	List<StudentProject> getTrendingProjects(Integer collegeId) throws BusinessServiceException;

}
