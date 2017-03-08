package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.DashboardService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.DashboardDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.College;
import com.revature.model.Department;
import com.revature.model.Student;
import com.revature.model.dto.StudentCourseDTO;
import com.revature.model.dto.StudentDTO;
import com.revature.model.dto.StudentProjectDTO;

@Service

public class DashboardServiceImpl implements DashboardService {

	private static Logger logger = Logger.getLogger(DashboardServiceImpl.class);

	@Autowired
	private DashboardDAO dashboardDAO;

	@Override
	public List<StudentCourseDTO> getActiveCourses(StudentDTO studentDTO)
			throws BusinessServiceException {
		List<StudentCourseDTO> activeCourses = null;
		Student student=new Student();
		College college=new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		Department department=new Department();
		department.setId(studentDTO.getDepartmentId());
		student.setDepartment(department);
		try {
			activeCourses = dashboardDAO.getActiveCourses(student);
			logger.info("Active courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return activeCourses;
	}

	@Override
	public List<StudentProjectDTO> getActiveProjects(StudentDTO studentDTO)
			throws BusinessServiceException {
		List<StudentProjectDTO> activeProjects = null;
		Student student=new Student();
		College college=new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		Department department=new Department();
		department.setId(studentDTO.getDepartmentId());
		student.setDepartment(department);
		try {
			activeProjects = dashboardDAO.getActiveProjects(student);
			logger.info("Active projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return activeProjects;
	}

	@Override
	public List<StudentCourseDTO> getTrendingCourses(StudentDTO studentDTO) throws BusinessServiceException {
		List<StudentCourseDTO> trendingCourses = null;
		Student student=new Student();
		College college=new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		try {
			trendingCourses = dashboardDAO.getTrendingCourses(student);
			logger.info("Trending courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return trendingCourses;
	}

	@Override
	public List<StudentProjectDTO> getTrendingProjects(StudentDTO studentDTO) throws BusinessServiceException {
		List<StudentProjectDTO> trendingProject = null;
		Student student=new Student();
		College college=new College();
		college.setId(studentDTO.getCollegeId());
		student.setCollege(college);
		try {
			trendingProject = dashboardDAO.getTrendingProjects(student);
			logger.info("Trending projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return trendingProject;
	}
}
