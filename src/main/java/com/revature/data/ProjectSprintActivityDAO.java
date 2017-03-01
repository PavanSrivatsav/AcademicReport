package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.ProjectSprintActivity;

public interface ProjectSprintActivityDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<ProjectSprintActivity> getAllProjectSprintActivities() throws DataServiceException;

	public List<ProjectSprintActivity> getProjectSprintActivityById(int projectSprintActivityId)
			throws DataServiceException;

}
