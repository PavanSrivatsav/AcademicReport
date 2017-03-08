package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Student;
import com.revature.model.dto.StudentCourseDTO;
import com.revature.model.dto.StudentDTO;
import com.revature.model.dto.StudentProjectDTO;

public interface StudentDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<StudentDTO> getAllStudents() throws DataServiceException;

	public <E> StudentDTO getStudentDetailsById(Student student) throws DataServiceException;

	public <E> StudentDTO getStudentByEmailId(Student student) throws DataServiceException;

	public List<StudentCourseDTO> getStudentCoursesByStudentId(Student student) throws DataServiceException;

	public List<StudentProjectDTO> getStudentProjectsByStudentId(Student student) throws DataServiceException;

/*	public List<StudentDTO> getOverAllStudentByCurrentCourses(Student student) throws DataServiceException;

	public List<StudentDTO> getOverAllStudentByCompletedCourses(Student student) throws DataServiceException;

	public List<StudentDTO> getOverAllStudentByCurrentProjects(Student student) throws DataServiceException;

	public List<StudentDTO> getOverAllStudentByCompletedProjects(Student student) throws DataServiceException;
*/	
	public List<StudentDTO> getAllStudentByCollege (Student student) throws DataServiceException;

}
