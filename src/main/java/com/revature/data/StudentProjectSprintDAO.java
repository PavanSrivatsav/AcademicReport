package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProjectSprint;

public interface StudentProjectSprintDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentProjectSprint> getAllStudentProjectSprints() throws DataServiceException;

	public List<StudentProjectSprint> getStudentProjectSprintsById(int Id) throws DataServiceException;

	public List<StudentProjectSprint> getStudentProjectSprintsByProjectSprintId(int sprintId)
			throws DataServiceException;

	public List<StudentProjectSprint> getStudentProjectSprintsByStudentProjectId(int projectId)
			throws DataServiceException;

}
