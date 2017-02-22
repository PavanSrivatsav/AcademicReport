package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.ProjectSprint;

public interface ProjectSprintDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<ProjectSprint> getAllProjectSprints() throws DataServiceException;

}
