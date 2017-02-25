package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Project;

public interface ProjectDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<Project> getAllProjects() throws DataServiceException;

	public List<Project> getProjectById(int projectId) throws DataServiceException;

	public List<Project> getProjectByName(String projectName) throws DataServiceException;

}
