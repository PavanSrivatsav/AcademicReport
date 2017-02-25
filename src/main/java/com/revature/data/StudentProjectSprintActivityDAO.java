package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProjectSprintActivity;

public interface StudentProjectSprintActivityDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentProjectSprintActivity> getAllStudentProjectSprintActivities() throws DataServiceException;

	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesById(Integer Id)
			throws DataServiceException;

	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesByProjectSprintActivityId(
			Integer sprintId) throws DataServiceException;

	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesByStudentProjectSprintId(
			Integer projectId) throws DataServiceException;

}
