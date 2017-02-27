package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CourseDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {

	private static Logger logger = Logger.getLogger(CourseDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<Course> getAllCourses() throws DataServiceException {
		try {
			StringBuilder sb = new StringBuilder("select * from courses c where c.IS_ACTIVE=true");
			logger.info("Courses data retrieval success..");
			return dataRetriver.retrieveBySQL(sb.toString());
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
	}

	@Override
	public List<Course> getCourseById(Integer id) throws DataServiceException {
		List<Course> coursesById = null;
		try {
			StringBuilder sb = new StringBuilder("select * from courses c where c.ID=" + id + " and c.IS_ACTIVE=true");
			coursesById = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Courses by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return coursesById;
	}

	@Override
	public List<Course> getCourseByName(String courseName) throws DataServiceException {
		List<Course> coursesByName = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from courses c where c.NAME='" + courseName + "' and c.IS_ACTIVE=true");
			coursesByName = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Courses by course name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return coursesByName;
	}

	@Override
	public List<Course> getCourseByCategoryId(Integer categoryId) throws DataServiceException {
		List<Course> coursesByCategoryId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from courses c where c.CATEGORY_ID=" + categoryId + " and c.IS_ACTIVE=true");
			coursesByCategoryId = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Courses by category id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return coursesByCategoryId;
	}
}
