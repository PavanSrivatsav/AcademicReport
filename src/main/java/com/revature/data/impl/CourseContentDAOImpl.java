package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CourseContentDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.CourseContent;
import com.revature.model.dto.CourseContentDTO;

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
	@Autowired
	private DataModifier dataModifier;

	public DataModifier getDataModifier() {
		return dataModifier;
	}

	public void setDataModifier(DataModifier dataModifier) {
		this.dataModifier = dataModifier;
	}


	@Override
	public List<CourseContentDTO> getAllCourseContents() throws DataServiceException {
		List<CourseContentDTO> courseContents = null;
		try {
			StringBuilder sb = new StringBuilder("select c.ID id,c.COURSE_ID courseId,c.VIDEO_ID videoId,c.TEXT_CONTENT textContent,c.IS_ACTIVE isActive from course_contents c where c.IS_ACTIVE=true");
			courseContents = dataRetriver.retrieveBySQLAsJSON(sb.toString(),CourseContentDTO.class);
			logger.info("Course contents data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseContents;
	}


	@Override
	public <E> CourseContentDTO getCourseContentById(CourseContent courseContent) throws DataServiceException {
		CourseContentDTO courseContentsById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select c.ID id,c.COURSE_ID courseId,c.VIDEO_ID videoId,c.TEXT_CONTENT textContent,c.IS_ACTIVE isActive from course_contents c where c.ID=" + courseContent.getId() + " and c.IS_ACTIVE=true");
			courseContentsById = (CourseContentDTO)dataRetriver.retrieveBySQLAsObject(sb.toString(),CourseContentDTO.class);
			logger.info("Course contents by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseContentsById;
	}

	@Override
	public List<CourseContentDTO>  getCourseContentByCourseId(CourseContent courseContent) throws DataServiceException {
		List<CourseContentDTO> courseContentByCourseId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select c.ID id,c.COURSE_ID courseId,c.VIDEO_ID videoId,c.TEXT_CONTENT textContent,c.IS_ACTIVE isActive from course_contents c where c.COURSE_ID=" + courseContent.getCourse().getId() + " and c.IS_ACTIVE=true");
			courseContentByCourseId = dataRetriver.retrieveBySQLAsJSON(sb.toString(),CourseContentDTO.class);
			logger.info("Course contents by course id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseContentByCourseId;
	}

	@Override
	public <E> CourseContentDTO getCourseContentByVideoId(CourseContent courseContent) throws DataServiceException {
	CourseContentDTO courseContentByVideoId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select c.ID id,c.COURSE_ID courseId,c.VIDEO_ID videoId,c.TEXT_CONTENT textContent,c.IS_ACTIVE isActive from course_contents c where c.VIDEO_ID=" + courseContent.getVideo().getId() + " and c.IS_ACTIVE=true");
			courseContentByVideoId = (CourseContentDTO)dataRetriver.retrieveBySQLAsObject(sb.toString(),CourseContentDTO.class);
			logger.info("Course contents by video id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseContentByVideoId;
	}

}
