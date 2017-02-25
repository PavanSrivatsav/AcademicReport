package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentProjectSprint;

public interface StudentProjectSprintService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<StudentProjectSprint> getAllStudentProjectSprints() throws BusinessServiceException;

	List<StudentProjectSprint> getStudentProjectSprintsById(Integer Id) throws BusinessServiceException;

	List<StudentProjectSprint> getStudentProjectSprintsByStudentProjectId(Integer studentProjectId)
			throws BusinessServiceException;

	List<StudentProjectSprint> getStudentProjectSprintsByProjectSprintId(Integer studentProjectSprintId)
			throws BusinessServiceException;
}
