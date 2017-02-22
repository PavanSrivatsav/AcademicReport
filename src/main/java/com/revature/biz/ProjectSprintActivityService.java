package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.ProjectSprintActivity;

public interface ProjectSprintActivityService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<ProjectSprintActivity> getAllProjectSprintActivities() throws BusinessServiceException;
}
