package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.DashboardDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Student;
import com.revature.model.dto.StudentCourseDTO;
import com.revature.model.dto.StudentProjectDTO;

@Repository

public class DashboardDAOImpl implements DashboardDAO {
	private static Logger logger = Logger.getLogger(DashboardDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<StudentCourseDTO> getActiveCourses(Student student) throws DataServiceException {
		List<StudentCourseDTO> activeCourses = null;
		try {
			if(student.getDepartment().getId()==5){
				
				StringBuilder sb = new StringBuilder(
						"SELECT ID id,NAME name,course_count courseCount, department_id departmentId,college_id collegeId FROM vw_active_courses WHERE  "
						+ "COLLEGE_ID=" + student.getCollege().getId());
				activeCourses = dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentCourseDTO.class);
				logger.info("Active courses data retrieval success..");
			}else
			{
			StringBuilder sb = new StringBuilder(
					"SELECT ID id,NAME name,course_count courseCount, department_id departmentId,college_id collegeId FROM vw_active_courses WHERE DEPARTMENT_ID="
							+ student.getDepartment().getId() + " AND COLLEGE_ID=" + student.getCollege().getId());
			activeCourses = dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentCourseDTO.class);
			logger.info("Active courses data retrieval success..");
			}
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return activeCourses;
	}

	@Override
	public List<StudentProjectDTO> getActiveProjects(Student student) throws DataServiceException {
		List<StudentProjectDTO> activeProjects = null;
		try {
			if(student.getDepartment().getId()==5){
				StringBuilder sb = new StringBuilder(
						"SELECT ID id,NAME name, project_count projectCount, department_id departmentId,college_id collegeId FROM vw_active_projects "
						+ "WHERE COLLEGE_ID=" + student.getCollege().getId());
				activeProjects = dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentProjectDTO.class);
				logger.info("Active projects data retrieval success..");
			}
			else
			{
			StringBuilder sb = new StringBuilder(
					"SELECT ID id,NAME name, project_count projectCount, department_id departmentId,college_id collegeId FROM vw_active_projects WHERE DEPARTMENT_ID="
							+ student.getDepartment().getId() + " AND COLLEGE_ID=" + student.getCollege().getId());
			activeProjects = dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentProjectDTO.class);
			logger.info("Active projects data retrieval success..");
			}
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return activeProjects;
	}

	@Override
	public List<StudentCourseDTO> getTrendingCourses(Student student) throws DataServiceException {
		List<StudentCourseDTO> trendingCourses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT students.college_id collegeId, courses.`NAME` courseName, COUNT(`student_id`) courseCount FROM `student_courses` JOIN `courses` ON `courses`.`ID`=`student_courses`.`COURSE_ID` JOIN `students`  ON students.`ID`=student_courses.`STUDENT_ID` WHERE `courses`.`IS_ACTIVE`=TRUE AND `students`.`COLLEGE_ID`="
							+ student.getCollege().getId()
							+ " GROUP BY `student_courses`.`COURSE_ID` ORDER BY COUNT(`COURSE_ID`) DESC LIMIT 5");
			trendingCourses = dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentCourseDTO.class);
			logger.info("Trending courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return trendingCourses;
	}

	@Override
	public List<StudentProjectDTO> getTrendingProjects(Student student) throws DataServiceException {
		List<StudentProjectDTO> trendingProjects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT students.college_id collegeId, projects.`NAME` projectName, COUNT(`student_id`) projectCount FROM `student_projects` JOIN `projects` ON `projects`.`ID`=`student_projects`.`PROJECT_ID` JOIN `students` ON students.`ID`=student_projects.`STUDENT_ID` WHERE projects.`IS_ACTIVE`=TRUE AND `students`.`COLLEGE_ID`="
							+ student.getCollege().getId()
							+ " GROUP BY `student_projects`.`PROJECT_ID` ORDER BY COUNT(`PROJECT_ID`) DESC LIMIT 5");
			trendingProjects = dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentProjectDTO.class);
			logger.info("Trending projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return trendingProjects;
	}
}
