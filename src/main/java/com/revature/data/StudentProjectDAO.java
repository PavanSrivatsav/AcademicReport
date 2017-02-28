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

	public List<StudentProject> getStudentProjectById(int studentProjectId) throws DataServiceException;

	public List<StudentProject> getStudentProjectByStudentId(int studentId) throws DataServiceException;

	public List<StudentProject> getStudentProjectByProjectId(int projectId) throws DataServiceException;
	
	public List<StudentProject> getCompletedStudentProjectCount(int studentId) throws DataServiceException;

}
