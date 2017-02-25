package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentCourseContentDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentCourseContent;

@Repository
public class StudentCourseContentDAOImpl implements StudentCourseContentDAO {

	private static Logger logger = Logger.getLogger(StudentCourseDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<StudentCourseContent> getAllStudentCourseContents() throws DataServiceException {
		List<StudentCourseContent> studentCoursesContents = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_course_contents");
			studentCoursesContents = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCoursesContents;
	}

	@Override
	public List<StudentCourseContent> getStudentCourseContentsByCourseContentId(int courseContentId)
			throws DataServiceException {
		List<StudentCourseContent> studentCoursesContents = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from student_course_contents where COURSE_CONTENT_ID='" + courseContentId + "'");
			studentCoursesContents = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentCourseContents data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCoursesContents;
	}

	@Override
	public List<StudentCourseContent> getStudentCourseContentsByStudentCourseId(int studentCourseId)
			throws DataServiceException {
		List<StudentCourseContent> studentCoursesContents = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from student_course_contents where STUDENT_COURSE_ID='" + studentCourseId + "'");
			studentCoursesContents = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCoursesContents;
	}

}
