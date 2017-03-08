package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.StudentCourseDTO;
import com.revature.model.dto.StudentDTO;
import com.revature.model.dto.StudentProjectDTO;

public interface DashboardService {

	/**
	 * Used to get all the categories.
	 * 
	 * @return categories
	 * @throws BusinessServiceException
	 *             if any business error occurs
	 */
	List<StudentCourseDTO> getActiveCourses(StudentDTO studentDTO) throws BusinessServiceException;

	List<StudentProjectDTO> getActiveProjects(StudentDTO studentDTO) throws BusinessServiceException;

	List<StudentCourseDTO> getTrendingCourses(StudentDTO studentDTO) throws BusinessServiceException;

	List<StudentProjectDTO> getTrendingProjects(StudentDTO studentDTO) throws BusinessServiceException;

}
