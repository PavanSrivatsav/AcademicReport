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
			StringBuilder sb = new StringBuilder("select * from student_courses where ID='"+studentCourseId+"'");
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
			StringBuilder sb = new StringBuilder("select * from student_courses where ID='"+studentId+"'");
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
			StringBuilder sb = new StringBuilder("select * from student_courses where ID='"+courseId+"'");
			studentCourses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}
}