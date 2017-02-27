package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourse;

public interface DashboardDAO {
	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentCourse> getActiveCourses(Integer collegeId,Integer departmentId) throws DataServiceException;
	


}
