package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.ProjectSprintActivityDTO;

public interface ProjectSprintActivityService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<ProjectSprintActivityDTO> getAllProjectSprintActivities() throws BusinessServiceException;
	
	ProjectSprintActivityDTO getProjectSprintActivityById(ProjectSprintActivityDTO projectSprintActivityDTO) throws BusinessServiceException;
	
	}
