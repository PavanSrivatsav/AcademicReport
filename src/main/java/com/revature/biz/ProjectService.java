package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Project;

public interface ProjectService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<Project> getAllProjects() throws BusinessServiceException;

	List<Project> getProjectById(Integer Id) throws BusinessServiceException;

	List<Project> getProjectByName(String projectName) throws BusinessServiceException;

	List<Project> getProjectByCategoryId(Integer categoryId) throws BusinessServiceException;
}