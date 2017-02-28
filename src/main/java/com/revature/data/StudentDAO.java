package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Student;

public interface StudentDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<Student> getAllStudents() throws DataServiceException;

	public List<Student> getStudentById(int studentId) throws DataServiceException;

	public List<Student> getStudentByEmailId(String sudentEmailId) throws DataServiceException;
	
	public List<Student> getIndividualStudentByCourses(Integer collegeId,Integer departmentId,Integer studentId) throws DataServiceException;
	
	public List<Student> getIndividualStudentByProjects(Integer collegeId,Integer departmentId,Integer studentId) throws DataServiceException;
}
