package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CourseDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.College;
import com.revature.model.Course;
import com.revature.model.dto.CollegeDTO;
import com.revature.model.dto.CourseDTO;

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

	@Autowired
	private DataModifier dataModifier;

	public DataModifier getDataModifier() {
		return dataModifier;
	}

	public void setDataModifier(DataModifier dataModifier) {
		this.dataModifier = dataModifier;
	}

	@Override
	public List<CourseDTO> getAllCourses() throws DataServiceException {
		List<CourseDTO> course = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select c.ID id,c.NAME name,c.CATEGORY_ID categoryId,c.DESCRIPTION description,c.DURATION_IN_MINUTES duration,c.IS_ACTIVE isActive from courses c where c.IS_ACTIVE=true");
			course = dataRetriver.retrieveBySQLAsJSON(sb.toString(), CourseDTO.class);
			logger.info("Courses data retrieval success..");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return course;
	}

	@Override
	public <E> CourseDTO getCourseById(Course course) throws DataServiceException {
		CourseDTO coursesById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select c.ID id,c.NAME name,c.CATEGORY_ID categoryId,c.DESCRIPTION description,c.DURATION_IN_MINUTES duration,c.IS_ACTIVE isActive from courses c where c.ID="
							+ course.getId() + " AND c.IS_ACTIVE=true");
			coursesById = (CourseDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(), CourseDTO.class);
			logger.info("Courses by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return coursesById;
	}

	@Override
	public <E> CourseDTO getCourseByName(Course course) throws DataServiceException {
		CourseDTO coursesByName = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select c.ID id,c.NAME name,c.CATEGORY_ID categoryId,c.DESCRIPTION description,c.DURATION_IN_MINUTES duration,c.IS_ACTIVE isActive from courses c where c.NAME='"
							+ course.getName() + "' and c.IS_ACTIVE=true");
			coursesByName = (CourseDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(), CourseDTO.class);
			logger.info("Courses by course name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return coursesByName;
	}

	@Override
	public List<CourseDTO> getCourseByCategoryId(Course course) throws DataServiceException {
		List<CourseDTO> coursesByCategoryId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select c.ID id,c.NAME name,c.CATEGORY_ID categoryId,c.DESCRIPTION description,c.DURATION_IN_MINUTES duration,c.IS_ACTIVE isActive from courses c where c.CATEGORY_ID="
							+ course.getCategory().getId() + " and c.IS_ACTIVE=true");
			coursesByCategoryId = dataRetriver.retrieveBySQLAsJSON(sb.toString(), CourseDTO.class);
			logger.info("Courses by category id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return coursesByCategoryId;
	}

	@Override
	public List<CollegeDTO> getCourseOverAllDetail(College college) throws DataServiceException {
		List<CollegeDTO> courseOverAllDetail = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT c.NAME name,c.DESCRIPTION description FROM courses c WHERE id IN (SELECT DISTINCT courses.`ID` FROM `student_courses` JOIN `courses` ON `courses`.`ID`=`student_courses`.`COURSE_ID` JOIN `students` ON students.`ID`=student_courses.`STUDENT_ID` WHERE `students`.`IS_ACTIVE`=TRUE AND `courses`.`IS_ACTIVE`=TRUE AND `students`.`COLLEGE_ID`= "
							+ college.getId() + " )");
			courseOverAllDetail = dataRetriver.retrieveBySQLAsJSON(sb.toString(), CourseDTO.class);
			logger.info("Courses over all details data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseOverAllDetail;
	}

	@Override
	public List<CourseDTO> getCourseDetail(Course course) throws DataServiceException {
		List<CourseDTO> courseDetail = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT id id, course_name name, text_content cont, video_name vidname, URL url FROM vw_course_content WHERE id=" + course.getId());
			courseDetail = dataRetriver.retrieveBySQLAsJSON(sb.toString(), CourseDTO.class);
			logger.info("Courses details data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courseDetail;
	}

	@Override
	public List<CourseDTO> getTotalCourseCount(Course course) throws DataServiceException {
		List<CourseDTO> totalCourseCount = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT id,course_count courseCnt FROM vw_course_content_count WHERE id =" + course.getId());
			totalCourseCount = dataRetriver.retrieveBySQLAsJSON(sb.toString(), CourseDTO.class);
			logger.info("Total Course Count data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return totalCourseCount;
	}
}
