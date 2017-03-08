package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.College;
import com.revature.model.Project;
import com.revature.model.dto.ProjectDTO;

public interface ProjectDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<ProjectDTO> getAllProjects() throws DataServiceException;

	public <E> ProjectDTO getProjectById(Project project) throws DataServiceException;

	public <E> ProjectDTO getProjectByName(Project project) throws DataServiceException;

	public List<ProjectDTO> getProjectByCategoryId(Project project) throws DataServiceException;

	public List<ProjectDTO> getProjectOverAllDetail(College college) throws DataServiceException;

	public List<ProjectDTO> getProjectDetail(Project project) throws DataServiceException;

	public List<ProjectDTO> getTotalProjectCount(Project project) throws DataServiceException;

}
