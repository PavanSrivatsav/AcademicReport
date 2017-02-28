package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentProject;

public interface StudentProjectService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<StudentProject> getAllStudentProjects() throws BusinessServiceException;

	List<StudentProject> getStudentProjectById(int studentProjectId) throws BusinessServiceException;

	List<StudentProject> getStudentProjectByStudentId(int studentId) throws BusinessServiceException;

	List<StudentProject> getStudentProjectByProjectId(int projectId) throws BusinessServiceException;
	
	List<StudentProject> getCompletedStudentProjectCount(int studentId) throws BusinessServiceException;
}
