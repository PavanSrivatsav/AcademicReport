package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.StudentProjectSprintDTO;

public interface StudentProjectSprintService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<StudentProjectSprintDTO> getAllStudentProjectSprints() throws BusinessServiceException;

	List<StudentProjectSprintDTO> getStudentProjectSprintsById(StudentProjectSprintDTO studentProjectSprintDTO) throws BusinessServiceException;

	List<StudentProjectSprintDTO> getStudentProjectSprintsByStudentProjectId(StudentProjectSprintDTO studentProjectSprintDTO)
			throws BusinessServiceException;

	List<StudentProjectSprintDTO> getStudentProjectSprintsByProjectSprintId(StudentProjectSprintDTO studentProjectSprintDTO)
			throws BusinessServiceException;
}
