package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.ProjectSprintDTO;

public interface ProjectSprintService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<ProjectSprintDTO> getAllProjectSprints() throws BusinessServiceException;

	List<ProjectSprintDTO> getProjectSprintById(ProjectSprintDTO projectSprintDTO) throws BusinessServiceException;
}
