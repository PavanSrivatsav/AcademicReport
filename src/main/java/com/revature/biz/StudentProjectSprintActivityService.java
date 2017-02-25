package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentProjectSprintActivity;

public interface StudentProjectSprintActivityService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<StudentProjectSprintActivity> getAllStudentProjectSprintActivities() throws BusinessServiceException;

	List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesById(Integer Id)
			throws BusinessServiceException;

	List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesByProjectSprintActivityId(
			Integer studentProjectId) throws BusinessServiceException;

	List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesByStudentProjectSprintId(
			Integer studentProjectSprintId) throws BusinessServiceException;
}
