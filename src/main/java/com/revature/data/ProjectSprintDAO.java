package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.ProjectSprint;
import com.revature.model.dto.ProjectSprintDTO;

public interface ProjectSprintDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<ProjectSprintDTO> getAllProjectSprints() throws DataServiceException;

	public List<ProjectSprintDTO> getProjectSprintById(ProjectSprint projectSprint) throws DataServiceException;

}
