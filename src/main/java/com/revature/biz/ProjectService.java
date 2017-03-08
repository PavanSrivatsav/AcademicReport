package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.CollegeDTO;
import com.revature.model.dto.ProjectDTO;

public interface ProjectService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	 List<ProjectDTO> getAllProjects() throws BusinessServiceException;

	 <E> ProjectDTO getProjectById(ProjectDTO projectDTO) throws BusinessServiceException;

	 <E> ProjectDTO getProjectByName(ProjectDTO projectDTO) throws BusinessServiceException;

	 List<ProjectDTO> getProjectByCategoryId(ProjectDTO projectDTO) throws BusinessServiceException;

	 List<ProjectDTO> getProjectOverAllDetail(CollegeDTO collegeDTO) throws BusinessServiceException;

	 List<ProjectDTO> getProjectDetail(ProjectDTO projectDTO) throws BusinessServiceException;

	 List<ProjectDTO> getTotalProjectCount(ProjectDTO projectDTO) throws BusinessServiceException;

}
