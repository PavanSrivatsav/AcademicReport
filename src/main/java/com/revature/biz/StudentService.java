package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Student;

public interface StudentService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<Student> getAllStudents() throws BusinessServiceException;

	List<Student> getStudentById(int studentId) throws BusinessServiceException;

	List<Student> getStudentByEmailId(String studentEmailId) throws BusinessServiceException;
}
