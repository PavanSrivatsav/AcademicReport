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
import com.revature.model.dto.StudentProjectDTO;

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
	public List<StudentProjectDTO> getAllStudentProjects() throws DataServiceException {
		List<StudentProjectDTO> studentProjects = null;
		try {
			StringBuilder sb = new StringBuilder("select sp.ID id,sp.STUDENT_ID studentId,sp.PROJECT_ID projectId,sp.STARTED_ON startedOn,sp.COMPLETED_ON completedOn,sp.STATUS_ID statusId from student_projects sp");
			studentProjects = dataRetriver.retrieveBySQLAsJSON(sb.toString(),StudentProjectDTO.class);
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjects;
	}

	@Override
	public <E> StudentProjectDTO getStudentProjectById(StudentProject studentProject) throws DataServiceException {
		StudentProjectDTO studentProjectById = null;
		try {
			StringBuilder sb = new StringBuilder("select sp.ID id,sp.STUDENT_ID studentId,sp.PROJECT_ID projectId,sp.STARTED_ON startedOn,sp.COMPLETED_ON completedOn,sp.STATUS_ID statusId from student_projects sp where ID=" + studentProject.getId());
			studentProjectById =(StudentProjectDTO) dataRetriver.retrieveBySQLAsJSON(sb.toString(),StudentProjectDTO.class);
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectById;
	}

	@Override
	public List<StudentProjectDTO> getStudentProjectByStudentId(StudentProject studentProject) throws DataServiceException {
		List<StudentProjectDTO> studentProjectByStudentId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select sp.ID id,sp.STUDENT_ID studentId,sp.PROJECT_ID projectId,sp.STARTED_ON startedOn,sp.COMPLETED_ON completedOn,sp.STATUS_ID statusId from student_projects sp where STUDENT_ID=" + studentProject.getStudent().getId());
			studentProjectByStudentId = dataRetriver.retrieveBySQLAsJSON(sb.toString(),StudentProjectDTO.class);
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectByStudentId;
	}

	@Override
	public List<StudentProjectDTO> getStudentProjectByProjectId(StudentProject studentProject) throws DataServiceException {
		List<StudentProjectDTO> studentProjectByProjectId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select sp.ID id,sp.STUDENT_ID studentId,sp.PROJECT_ID projectId,sp.STARTED_ON startedOn,sp.COMPLETED_ON completedOn,sp.STATUS_ID statusId from student_projects sp where PROJECT_ID=" + studentProject.getProject().getId());
			studentProjectByProjectId =  dataRetriver.retrieveBySQLAsJSON(sb.toString(),StudentProjectDTO.class);
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectByProjectId;
	}

	@Override
	public <E> StudentProjectDTO getCompletedStudentProjectCount(StudentProject studentProject) throws DataServiceException {
		StudentProjectDTO completedStudentProjectCount = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT COUNT(projects.`ID`) FROM projects JOIN student_projects ON projects.`ID`=student_projects.`PROJECT_ID` JOIN student_project_sprints ON student_projects.`ID`=student_project_sprints.`STUDENT_PROJECT_ID` JOIN student_project_sprint_activities ON student_project_sprints.`ID`=student_project_sprint_activities.`STUDENT_PROJECT_SPRINT_ID` WHERE projects.`IS_ACTIVE`=TRUE AND student_project_sprint_activities.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='COMPLETED') AND student_projects.`STUDENT_ID` ="
							+ studentProject.getStudent().getId()+" AND projects.`ID`="+studentProject.getProject().getId());
			completedStudentProjectCount = (StudentProjectDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(),StudentProjectDTO.class);
			logger.info("Completed Student Project Count data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return completedStudentProjectCount;
	}

}
