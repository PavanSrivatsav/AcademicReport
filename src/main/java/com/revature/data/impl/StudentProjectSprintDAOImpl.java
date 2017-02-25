package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentProjectSprintDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentProjectSprint;

@Repository
public class StudentProjectSprintDAOImpl implements StudentProjectSprintDAO {

	private static Logger logger = Logger.getLogger(StudentProjectSprintDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<StudentProjectSprint> getAllStudentProjectSprints() throws DataServiceException {
		List<StudentProjectSprint> studentProjectsSprint = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_project_sprints");
			studentProjectsSprint = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectsSprint;
	}

	@Override
	public List<StudentProjectSprint> getStudentProjectSprintsById(int studentProjectSprintId)
			throws DataServiceException {
		List<StudentProjectSprint> studentProjectById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from student_project_sprints where ID='" + studentProjectSprintId + "'");
			studentProjectById = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectById;
	}

	@Override
	public List<StudentProjectSprint> getStudentProjectSprintsByProjectSprintId(int sprintId)
			throws DataServiceException {
		List<StudentProjectSprint> studentProjectBySprntId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from student_project_sprints where PROJECT_SPRINT_ID=' " + sprintId + " ' ");
			studentProjectBySprntId = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectBySprntId;
	}

	@Override
	public List<StudentProjectSprint> getStudentProjectSprintsByStudentProjectId(int projectId)
			throws DataServiceException {
		List<StudentProjectSprint> studentProjectByStudentProjId = null;
		try {
			StringBuilder sb = new StringBuilder(
					" select * from student_project_sprints where STUDENT_PROJECT_ID=' " + projectId + " ' ");
			studentProjectByStudentProjId = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectByStudentProjId;
	}
}
