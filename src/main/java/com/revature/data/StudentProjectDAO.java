package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProject;
import com.revature.model.dto.StudentProjectDTO;

public interface StudentProjectDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentProjectDTO> getAllStudentProjects() throws DataServiceException;

	public <E> StudentProjectDTO getStudentProjectById(StudentProject studentProject) throws DataServiceException;

	public List<StudentProjectDTO> getStudentProjectByStudentId(StudentProject studentProject) throws DataServiceException;

	public List<StudentProjectDTO> getStudentProjectByProjectId(StudentProject studentProject) throws DataServiceException;

	public <E> StudentProjectDTO getCompletedStudentProjectCount(StudentProject studentProject) throws DataServiceException;

}
