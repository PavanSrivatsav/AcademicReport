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
import com.revature.model.dto.StudentProjectSprintDTO;

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
	public List<StudentProjectSprintDTO> getAllStudentProjectSprints() throws DataServiceException {
		List<StudentProjectSprintDTO> studentProjectsSprint = null;
		try {
			StringBuilder sb = new StringBuilder("select sps.id id,sps.student_project_id studentProjectId,sps.project_sprint_id projectSprintId,sps.started_on startedOn,sps.completed_on completedOn,sps.status_id statusId FROM student_project_sprints sps");
			studentProjectsSprint = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectsSprint;
	}

	@Override
	public List<StudentProjectSprintDTO> getStudentProjectSprintsById(StudentProjectSprint studentProjectSprint)
			throws DataServiceException {
		List<StudentProjectSprintDTO> studentProjectById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select sps.id id,sps.student_project_id studentProjectId,sps.project_sprint_id projectSprintId,sps.started_on startedOn,sps.completed_on completedOn,sps.status_id statusId FROM student_project_sprints sps where ID=" + studentProjectSprint.getId());
			studentProjectById = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectById;
	}

	@Override
	public List<StudentProjectSprintDTO> getStudentProjectSprintsByProjectSprintId(StudentProjectSprint studentProjectSprint)
			throws DataServiceException {
		List<StudentProjectSprintDTO> studentProjectBySprntId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select sps.id id,sps.student_project_id studentProjectId,sps.project_sprint_id projectSprintId,sps.started_on startedOn,sps.completed_on completedOn,sps.status_id statusId FROM student_project_sprints sps where PROJECT_SPRINT_ID=" +studentProjectSprint.getProjectSprint().getId());
			studentProjectBySprntId = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectBySprntId;
	}

	@Override
	public List<StudentProjectSprintDTO> getStudentProjectSprintsByStudentProjectId(StudentProjectSprint studentProjectSprint)
			throws DataServiceException {
		List<StudentProjectSprintDTO> studentProjectByStudentProjId = null;
		try {
			StringBuilder sb = new StringBuilder(
					" select sps.id id,sps.student_project_id studentProjectId,sps.project_sprint_id projectSprintId,sps.started_on startedOn,sps.completed_on completedOn,sps.status_id statusId FROM student_project_sprints sps where STUDENT_PROJECT_ID=" + studentProjectSprint.getStudentProject().getId());
			studentProjectByStudentProjId = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("StudentProjectsSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectByStudentProjId;
	}
}
