package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.StudentCourseDTO;

public interface StudentCourseService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<StudentCourseDTO> getAllStudentCourses() throws BusinessServiceException;

	StudentCourseDTO getStudentCourseById(StudentCourseDTO studentCourseDTO) throws BusinessServiceException;

	List<StudentCourseDTO> getStudentCourseByStudentId(StudentCourseDTO studentCourseDTO) throws BusinessServiceException;

	List<StudentCourseDTO> getStudentCourseByCourseId(StudentCourseDTO studentCourseDTO) throws BusinessServiceException;

	List<StudentCourseDTO> getCompletedStudentCourseCount(StudentCourseDTO studentCourseDTO) throws BusinessServiceException;
}
