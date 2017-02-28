package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.DashboardService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.DashboardDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourse;
import com.revature.model.StudentProject;
@Service

public class DashboardServiceImpl implements DashboardService {
	
	private static Logger logger = Logger.getLogger(DashboardServiceImpl.class);

	@Autowired
	private DashboardDAO dashboardDAO;

	@Override
	public List<StudentCourse> getActiveCourses(Integer collegeId,Integer departmentId) throws BusinessServiceException {
		List<StudentCourse> activeCourses= null;
		try {
			activeCourses = dashboardDAO.getActiveCourses(collegeId,departmentId);
			logger.info("Active courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return activeCourses;
	}
	@Override
	public List<StudentProject> getActiveProjects(Integer collegeId,Integer departmentId) throws BusinessServiceException {
		List<StudentProject> activeProjects= null;
		try {
			activeProjects = dashboardDAO.getActiveProjects(collegeId,departmentId);
			logger.info("Active projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return activeProjects;
	}
	@Override
	public List<StudentCourse> getTrendingCourses(Integer collegeId) throws BusinessServiceException {
		List<StudentCourse> trendingCourses= null;
		try {
			trendingCourses = dashboardDAO.getTrendingCourses(collegeId);
			logger.info("Trending courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return trendingCourses;
	}
	@Override
	public List<StudentProject> getTrendingProjects(Integer collegeId) throws BusinessServiceException {
		List<StudentProject> trendingProject= null;
		try {
			trendingProject = dashboardDAO.getTrendingProjects(collegeId);
			logger.info("Trending projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return trendingProject;
	}
}
