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
		List<Course> courses = null;
		try {
			StringBuilder sb = new StringBuilder("select * from courses c where c.IS_ACTIVE=true");
			courses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courses;
	}

	@Override
	public List<Course> getCourseById(int courseId) throws DataServiceException {
		return null;
	}

	@Override
	public List<Course> getCourseByName(String courseName) throws DataServiceException {
		return null;
	}
}
