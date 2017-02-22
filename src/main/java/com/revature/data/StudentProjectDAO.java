package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProject;

public interface StudentProjectDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentProject> getAllStudentProjects() throws DataServiceException;

}
