package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.College;
import com.revature.model.Department;
import com.revature.model.Student;
import com.revature.model.dto.StudentCourseDTO;
import com.revature.model.dto.StudentDTO;
import com.revature.model.dto.StudentProjectDTO;

@Service
public class StudentServiceImpl implements StudentService {
	private static Logger logger = Logger.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<StudentDTO> getAllStudents() throws BusinessServiceException {
		List<StudentDTO> students = null;
		try {
			students = studentDAO.getAllStudents();
			logger.info("Student retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return students;
	}

	@Override
	public StudentDTO getStudentById(StudentDTO studentDTO) throws BusinessServiceException {
		StudentDTO individualStudentByCourses = null;
		Student student = new Student();
		student.setId(studentDTO.getId());
		College college = new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		Department department = new Department();
		department.setId(studentDTO.getDepartmentId());
		student.setDepartment(department);
		try {
			individualStudentByCourses = studentDAO.getStudentDetailsById(student);
			logger.info("Individual Student By Courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return individualStudentByCourses;
	}

	@Override
	public StudentDTO getStudentByEmailId(StudentDTO studentDTO) throws BusinessServiceException {
		return null;
	}

	@Override
	public List <StudentCourseDTO> getStudentCoursesByStudentId(StudentDTO studentDTO) throws BusinessServiceException {
		List <StudentCourseDTO> individualStudentByCourses = null;
		Student student = new Student();
		student.setId(studentDTO.getId());
		College college = new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		Department department = new Department();
		department.setId(studentDTO.getDepartmentId());
		student.setDepartment(department);
		try {
			individualStudentByCourses = studentDAO.getStudentCoursesByStudentId(student);
			logger.info("Individual Student By Courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return individualStudentByCourses;
	}

	@Override
	public List<StudentProjectDTO> getStudentProjectsByStudentId(StudentDTO studentDTO) throws BusinessServiceException {
		List <StudentProjectDTO> individualStudentByProjects = null;
		Student student = new Student();
		student.setId(studentDTO.getId());
		College college = new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		Department department = new Department();
		department.setId(studentDTO.getDepartmentId());
		student.setDepartment(department);
		try {
			individualStudentByProjects = studentDAO.getStudentProjectsByStudentId(student);
			logger.info("Individual Student By Projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return individualStudentByProjects;
	}

/*	@Override
	public List<StudentDTO> getOverAllStudentByCurrentCourses(StudentDTO studentDTO) throws BusinessServiceException {
		List<StudentDTO> overAllStudentByCurrentCourses = null;
		Student student = new Student();
		College college = new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		Department department = new Department();
		department.setId(studentDTO.getDepartmentId());
		student.setDepartment(department);
		try {
			overAllStudentByCurrentCourses = studentDAO.getOverAllStudentByCurrentCourses(student);
			logger.info("Over All Student By Current Courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return overAllStudentByCurrentCourses;
	}

	@Override
	public List<StudentDTO> getOverAllStudentByCompletedCourses(StudentDTO studentDTO) throws BusinessServiceException {
		List<StudentDTO> overAllStudentByCompletedCourses = null;
		Student student = new Student();
		College college = new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		Department department = new Department();
		department.setId(studentDTO.getDepartmentId());
		student.setDepartment(department);
		try {
			overAllStudentByCompletedCourses = studentDAO.getOverAllStudentByCompletedCourses(student);
			logger.info("Over All Student By Completed Courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return overAllStudentByCompletedCourses;
	}

	@Override
	public List<StudentDTO> getOverAllStudentByCurrentProjects(StudentDTO studentDTO) throws BusinessServiceException {
		List<StudentDTO> overAllStudentByCurrentProjects = null;
		Student student = new Student();
		College college = new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		Department department = new Department();
		department.setId(studentDTO.getDepartmentId());
		student.setDepartment(department);
		try {
			overAllStudentByCurrentProjects = studentDAO.getOverAllStudentByCurrentProjects(student);
			logger.info("Over All Student By Current Projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return overAllStudentByCurrentProjects;
	}

	@Override
	public List<StudentDTO> getOverAllStudentByCompletedProjects(StudentDTO studentDTO)
			throws BusinessServiceException {
		List<StudentDTO> overAllStudentByCompletedProjects = null;
		Student student = new Student();
		College college = new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		Department department = new Department();
		department.setId(studentDTO.getDepartmentId());
		student.setDepartment(department);
		try {
			overAllStudentByCompletedProjects = studentDAO.getOverAllStudentByCompletedProjects(student);
			logger.info("Over All Student By Completed Projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return overAllStudentByCompletedProjects;
	}
*/
	@Override
	public List<StudentDTO> getAllStudentByCollege(StudentDTO studentDTO) throws BusinessServiceException {
		List<StudentDTO> overAllStudentByCollege = null;
		Student student = new Student();
		College college = new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		Department department = new Department();
		department.setId(studentDTO.getDepartmentId());
		student.setDepartment(department);
		try {
			overAllStudentByCollege = studentDAO.getAllStudentByCollege(student);
			logger.info("Over All Students By College retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return overAllStudentByCollege;
	}

}
