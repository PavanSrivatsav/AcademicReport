package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentCourseDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentCourse;

@Repository
public class StudentCourseDAOImpl implements StudentCourseDAO {

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
	public List<StudentCourse> getAllStudentCourses() throws DataServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_courses");
			studentCourses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourse> getStudentCourseById(int studentCourseId) throws DataServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_courses where ID='" + studentCourseId + "'");
			studentCourses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourse> getStudentCourseByStudentId(int studentId) throws DataServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_courses where ID='" + studentId + "'");
			studentCourses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourse> getStudentCourseByCourseId(int courseId) throws DataServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_courses where ID='" + courseId + "'");
			studentCourses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourse> getCompletedStudentCourseCount(int studentId, int courseId) throws DataServiceException {
		List<StudentCourse> completedStudentCourseCount = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT COUNT(courses.`ID`) FROM courses JOIN student_courses ON courses.`ID`=student_courses.`COURSE_ID` JOIN student_course_contents ON student_course_contents.`STUDENT_COURSE_ID`=student_courses.`ID` WHERE courses.`IS_ACTIVE`=TRUE AND student_course_contents.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='COMPLETED')   AND student_courses.`STUDENT_ID`="
							+ studentId + " AND courses.`ID`= " + courseId);
			completedStudentCourseCount = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Completed Student Course Count data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return completedStudentCourseCount;
	}
}
