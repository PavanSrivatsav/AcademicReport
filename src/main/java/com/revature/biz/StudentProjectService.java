package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.StudentProjectDTO;

public interface StudentProjectService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<StudentProjectDTO> getAllStudentProjects() throws BusinessServiceException;

	<E> StudentProjectDTO getStudentProjectById(StudentProjectDTO studentProjectDTO) throws BusinessServiceException;

	List<StudentProjectDTO> getStudentProjectByStudentId(StudentProjectDTO studentProjectDTO) throws BusinessServiceException;

	List<StudentProjectDTO> getStudentProjectByProjectId(StudentProjectDTO studentProjectDTO) throws BusinessServiceException;

	<E> StudentProjectDTO getCompletedStudentProjectCount(StudentProjectDTO studentProjectDTO) throws BusinessServiceException;
}
