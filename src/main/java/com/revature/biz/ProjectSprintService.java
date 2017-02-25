package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.ProjectSprint;

public interface ProjectSprintService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<ProjectSprint> getAllProjectSprints() throws BusinessServiceException;

	List<ProjectSprint> getProjectSprintById(int id) throws BusinessServiceException;
}
