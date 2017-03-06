package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentProjectSprintActivityDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentProjectSprintActivity;

@Repository
public class StudentProjectSprintActivityDAOImpl implements StudentProjectSprintActivityDAO {

	private static Logger logger = Logger.getLogger(StudentProjectSprintActivityDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<StudentProjectSprintActivity> getAllStudentProjectSprintActivities() throws DataServiceException {
		List<StudentProjectSprintActivity> studentProjectsSprint = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_project_sprint_activities");
			studentProjectsSprint = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("StudentProjectsSprintActivities data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectsSprint;
	}

	@Override
	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesById(Integer id)
			throws DataServiceException {
		List<StudentProjectSprintActivity> studentProjectSprintActivitiesById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from student_project_sprint_activities where ID='" + id + "'");
			studentProjectSprintActivitiesById = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectSprintActivitiesById;
	}

	@Override
	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesByProjectSprintActivityId(
			Integer projectSprintActivityId) throws DataServiceException {
		List<StudentProjectSprintActivity> studentProjectSprintActivitiesByProjectSprintActivityId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from student_project_sprint_activities where PROJECT_SPRINT_ACTIVITY_ID=' "
							+ projectSprintActivityId + " ' ");
			studentProjectSprintActivitiesByProjectSprintActivityId = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectSprintActivitiesByProjectSprintActivityId;
	}

	@Override
	public List<StudentProjectSprintActivity> getStudentProjectSprintActivitiesByStudentProjectSprintId(
			Integer studentProjectSprintId) throws DataServiceException {
		List<StudentProjectSprintActivity> studentProjectSprintActivitiesByStudentProjectSprintId = null;
		try {
			StringBuilder sb = new StringBuilder(
					" select * from student_project_sprint_activities where STUDENT_PROJECT_SPRINT_ID=' "
							+ studentProjectSprintId + " ' ");
			studentProjectSprintActivitiesByStudentProjectSprintId = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectSprintActivitiesByStudentProjectSprintId;
	}
}
