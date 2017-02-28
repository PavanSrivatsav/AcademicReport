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
	@Override
	public List<Course> getCourseOverAllDetail(Integer collegeId) throws DataServiceException {
		List<Course> courseOverAllDetail = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT NAME,DESCRIPTION FROM courses WHERE id IN (SELECT DISTINCT courses.`ID` FROM `student_courses` JOIN `courses` ON `courses`.`ID`=`student_courses`.`COURSE_ID` JOIN `students` ON students.`ID`=student_courses.`STUDENT_ID` WHERE `students`.`COLLEGE_ID`= " +collegeId+ " )");
			courseOverAllDetail = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Courses over all details data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseOverAllDetail;
	}
	@Override
	public List<Course> getCourseDetail(Integer courseId) throws DataServiceException {
		List<Course> courseDetail = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT c.NAME,cc.TEXT_CONTENT,v.NAME as 'videoname' FROM course_contents cc JOIN courses c ON cc.COURSE_ID=c.`ID` LEFT JOIN `videos` v ON  v.`ID`=cc.`VIDEO_ID` WHERE c.`ID`="+courseId);
			courseDetail = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Courses details data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseDetail;
	}
	@Override
	public List<Course> getTotalCourseCount(Integer courseId) throws DataServiceException {
		List<Course> totalCourseCount = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT COUNT(courses.`ID`) FROM courses JOIN course_contents ON courses.`ID`=course_contents.`COURSE_ID` WHERE courses.`IS_ACTIVE`=TRUE AND courses.`ID`="+courseId);
			totalCourseCount = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Total Course Count data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return totalCourseCount;
	}
}
