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
			courseContents = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Course contents data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseContents;
	}

	@Override
	public List<CourseContent> getCourseContentById(Integer id) throws DataServiceException {
		List<CourseContent> courseContentsById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from course_contents c where c.ID=" + id + " and c.IS_ACTIVE=true");
			courseContentsById = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Course contents by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseContentsById;
	}

	@Override
	public List<CourseContent> getCourseContentByCourseId(Integer courseId) throws DataServiceException {
		List<CourseContent> courseContentByCourseId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from course_contents c where c.COURSE_ID=" + courseId + " and c.IS_ACTIVE=true");
			courseContentByCourseId = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Course contents by course id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseContentByCourseId;
	}

	@Override
	public List<CourseContent> getCourseContentByVideoId(Integer videoId) throws DataServiceException {
		List<CourseContent> courseContentByVideoId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from course_contents c where c.VIDEO_ID=" + videoId + " and c.IS_ACTIVE=true");
			courseContentByVideoId = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Course contents by video id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseContentByVideoId;
	}

}
