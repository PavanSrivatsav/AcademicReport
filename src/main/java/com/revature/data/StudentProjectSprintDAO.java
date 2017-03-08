package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProjectSprint;
import com.revature.model.dto.StudentProjectSprintDTO;

public interface StudentProjectSprintDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentProjectSprintDTO> getAllStudentProjectSprints() throws DataServiceException;

	public List<StudentProjectSprintDTO> getStudentProjectSprintsById(StudentProjectSprint studentProjectSprint) throws DataServiceException;

	public List<StudentProjectSprintDTO> getStudentProjectSprintsByProjectSprintId(StudentProjectSprint studentProjectSprint)
			throws DataServiceException;

	public List<StudentProjectSprintDTO> getStudentProjectSprintsByStudentProjectId(StudentProjectSprint studentProjectSprint)
			throws DataServiceException;

}
