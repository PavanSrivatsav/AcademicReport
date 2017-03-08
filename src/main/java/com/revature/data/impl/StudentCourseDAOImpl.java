package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentCourseDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentCourse;
import com.revature.model.dto.StudentCourseDTO;

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
	@Autowired
	private DataModifier dataModifier;

	public DataModifier getDataModifier() {
		return dataModifier;
	}

	public void setDataModifier(DataModifier dataModifier) {
		this.dataModifier = dataModifier;
	}


	@Override
	public List<StudentCourseDTO> getAllStudentCourses() throws DataServiceException {
		List<StudentCourseDTO> studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder("select sc.ID id,sc.STUDENT_ID studentId,sc.COURSE_ID courseId,sc.STARTED_ON startedOn,sc.COMPLETED_ON completedOn,sc.STATUS_ID statusId from student_courses sc");
			studentCourses = dataRetriver.retrieveBySQLAsJSON(sb.toString(),StudentCourseDTO.class);
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

	@Override
	public <E> StudentCourseDTO getStudentCourseById(StudentCourse studentCourse) throws DataServiceException {
		StudentCourseDTO studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder("select sc.ID id,sc.STUDENT_ID studentId,sc.COURSE_ID courseId,sc.STARTED_ON startedOn,sc.COMPLETED_ON completedOn,sc.STATUS_ID statusId from student_courses sc where sc.ID=" + studentCourse.getId());
			studentCourses = (StudentCourseDTO)dataRetriver.retrieveBySQLAsObject(sb.toString(),StudentCourseDTO.class);
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourseDTO> getStudentCourseByStudentId(StudentCourse studentCourse) throws DataServiceException {
		List<StudentCourseDTO> studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder("select sc.Id id,sc.STUDENT_ID studentId,sc.COURSE_ID courseId,sc.STARTED_ON startedOn,sc.COMPLETED_ON completedOn,sc.STATUS_ID statusId from student_courses sc where sc.STUDENT_ID="+ studentCourse.getStudent().getId() );
			studentCourses = dataRetriver.retrieveBySQLAsJSON(sb.toString(),StudentCourseDTO.class);
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourseDTO> getStudentCourseByCourseId(StudentCourse studentCourse) throws DataServiceException {
		List<StudentCourseDTO> studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder("select sc.Id id,sc.STUDENT_ID studentId,sc.COURSE_ID courseId,sc.STARTED_ON startedOn,sc.COMPLETED_ON completedOn,sc.STATUS_ID statusId from student_courses sc where sc.COURSE_ID=" +studentCourse.getCourse().getId());
			studentCourses = dataRetriver.retrieveBySQLAsJSON(sb.toString(),StudentCourseDTO.class);
			logger.info("StudentCourses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourseDTO> getCompletedStudentCourseCount(StudentCourse studentCourse) throws DataServiceException {
		List<StudentCourseDTO> completedStudentCourseCount = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT c.ID id, COUNT(c.`ID`) count FROM courses c JOIN student_courses ON c.`ID`=student_courses.`COURSE_ID` JOIN student_course_contents ON student_course_contents.`STUDENT_COURSE_ID`=student_courses.`ID` WHERE c.`IS_ACTIVE`=TRUE AND student_course_contents.`STATUS_ID`=(SELECT id FROM `seed_status`  WHERE `seed_status`.`NAME`='COMPLETED')   AND student_courses.`STUDENT_ID`="
                            + studentCourse.getStudent().getId() + " AND student_courses.`COURSE_ID`= " + studentCourse.getCourse().getId());
			completedStudentCourseCount = dataRetriver.retrieveBySQLAsJSON(sb.toString(),StudentCourseDTO.class);
			logger.info("Completed Student Course Count data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return completedStudentCourseCount;
	}
}
