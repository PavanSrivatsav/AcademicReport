package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.ProjectSprintActivity;
import com.revature.model.dto.ProjectSprintActivityDTO;

public interface ProjectSprintActivityDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<ProjectSprintActivityDTO> getAllProjectSprintActivities() throws DataServiceException;
	
	public <E> ProjectSprintActivityDTO getProjectSprintActivityById(ProjectSprintActivity projectSprintActivity) throws DataServiceException;



}
