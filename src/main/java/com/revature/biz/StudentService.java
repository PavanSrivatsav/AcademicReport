package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.StudentCourseDTO;
import com.revature.model.dto.StudentDTO;
import com.revature.model.dto.StudentProjectDTO;

public interface StudentService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<StudentDTO> getAllStudents() throws BusinessServiceException;

	StudentDTO getStudentById(StudentDTO studentDTO) throws BusinessServiceException;

	StudentDTO getStudentByEmailId(StudentDTO studentDTO) throws BusinessServiceException;

	List <StudentCourseDTO> getStudentCoursesByStudentId(StudentDTO studentDTO) throws BusinessServiceException;

	List <StudentProjectDTO> getStudentProjectsByStudentId(StudentDTO studentDTO) throws BusinessServiceException;

/*	List<StudentDTO> getOverAllStudentByCurrentCourses(StudentDTO studentDTO) throws BusinessServiceException;

	List<StudentDTO> getOverAllStudentByCompletedCourses(StudentDTO studentDTO) throws BusinessServiceException;

	List<StudentDTO> getOverAllStudentByCurrentProjects(StudentDTO studentDTO) throws BusinessServiceException;

	List<StudentDTO> getOverAllStudentByCompletedProjects(StudentDTO studentDTO) throws BusinessServiceException;
*/	
	List<StudentDTO> getAllStudentByCollege (StudentDTO studentDTO) throws BusinessServiceException;
	
}
