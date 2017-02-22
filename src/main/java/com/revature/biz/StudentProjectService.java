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
}
