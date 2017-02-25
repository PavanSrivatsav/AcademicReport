package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CourseContentDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.CourseContent;

@Repository
public class CourseContentDAOImpl implements CourseContentDAO {

	private static Logger logger = Logger.getLogger(CourseContentDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<CourseContent> getAllCourseContents() throws DataServiceException {
		List<CourseContent> courseContents = null;
		try {
			StringBuilder sb = new StringBuilder("select * from course_contents c where c.IS_ACTIVE=true");
			courseContents = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Course contents data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseContents;
	}

	@Override
	public List<CourseContent> getCourseContentById(int courseId) throws DataServiceException {
		return null;
	}

}
