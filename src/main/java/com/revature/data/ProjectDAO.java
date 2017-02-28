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

	public List<Project> getProjectById(Integer Id) throws DataServiceException;

	public List<Project> getProjectByName(String projectName) throws DataServiceException;

	public List<Project> getProjectByCategoryId(Integer categoryId) throws DataServiceException;
	
	public List<Project> getProjectOverAllDetail(Integer collegeId) throws DataServiceException;
	
	public List<Project> getProjectDetail(Integer projectId) throws DataServiceException;
	
	public List<Project> getTotalProjectCount(Integer projectId) throws DataServiceException;

}
