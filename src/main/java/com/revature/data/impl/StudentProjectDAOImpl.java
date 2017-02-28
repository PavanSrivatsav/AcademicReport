package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentProjectDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentProject;

@Repository
public class StudentProjectDAOImpl implements StudentProjectDAO {

	private static Logger logger = Logger.getLogger(StudentProjectDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<StudentProject> getAllStudentProjects() throws DataServiceException {
		List<StudentProject> studentProjects = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_projects");
			studentProjects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjects;
	}

	@Override
	public List<StudentProject> getStudentProjectById(int studentProjectId) throws DataServiceException {
		List<StudentProject> studentProjectById = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_projects where ID='" + studentProjectId + "'");
			studentProjectById = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectById;
	}

	@Override
	public List<StudentProject> getStudentProjectByStudentId(int studentId) throws DataServiceException {
		List<StudentProject> studentProjectByStudentId = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_projects where STUDENT_ID=' "+ studentId +" ' ");
			studentProjectByStudentId = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectByStudentId;
	}

	@Override
	public List<StudentProject> getStudentProjectByProjectId(int projectId) throws DataServiceException {
		List<StudentProject> studentProjectByProjectId = null;
		try {
			StringBuilder sb = new StringBuilder(
					" select * from student_projects where PROJECT_ID=' "+ projectId +" ' ");
			studentProjectByProjectId = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectByProjectId;
	}
	@Override
	public List<StudentProject> getCompletedStudentProjectCount(int studentId) throws DataServiceException {
		List<StudentProject> completedStudentProjectCount = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT COUNT(projects.`ID`) FROM projects JOIN student_projects ON projects.`ID`=student_projects.`PROJECT_ID` JOIN student_project_sprints ON student_projects.`ID`=student_project_sprints.`STUDENT_PROJECT_ID` JOIN student_project_sprint_activities ON student_project_sprints.`ID`=student_project_sprint_activities.`STUDENT_PROJECT_SPRINT_ID` WHERE projects.`IS_ACTIVE`=TRUE AND student_project_sprint_activities.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='COMPLETED') AND student_projects.`STUDENT_ID` ="+ studentId );
			completedStudentProjectCount = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Completed Student Project Count data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return completedStudentProjectCount;
	}

}
