package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.ProjectDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private static Logger logger = Logger.getLogger(ProjectDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<Project> getAllProjects() throws DataServiceException {
		List<Project> projects = null;
		try {
			StringBuilder sb = new StringBuilder("select * from projects p where p.IS_ACTIVE=true");
			projects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projects;
	}

	@Override
	public List<Project> getProjectById(Integer id) throws DataServiceException {
		List<Project> projectById = null;
		try {
			StringBuilder sb = new StringBuilder("select * from projects p where ID=" + id + " and p.IS_ACTIVE=true");
			projectById = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Projects by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectById;
	}

	@Override
	public List<Project> getProjectByName(String projectName) throws DataServiceException {
		List<Project> projectByName = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from projects p where NAME='" + projectName + "' and p.IS_ACTIVE=true");
			projectByName = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Projects by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectByName;
	}

	@Override
	public List<Project> getProjectByCategoryId(Integer categoryId) throws DataServiceException {
		List<Project> projectByCategoryId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from projects p where CATEGORY_ID=" + categoryId + " and p.IS_ACTIVE=true");
			projectByCategoryId = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Projects by category id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectByCategoryId;
	}

	@Override
	public List<Project> getProjectOverAllDetail(Integer collegeId) throws DataServiceException {
		List<Project> projectOverAllDetail = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT NAME,DESCRIPTION FROM projects WHERE id IN (SELECT DISTINCT projects.`ID` FROM `student_projects` JOIN `projects` ON `projects`.`ID`=`student_projects`.`PROJECT_ID` JOIN `students` ON students.`ID`=student_projects.`STUDENT_ID` WHERE `students`.`IS_ACTIVE`=TRUE AND projects.`IS_ACTIVE`=TRUE AND `students`.`COLLEGE_ID`= "
							+ collegeId + " )");
			projectOverAllDetail = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Projects over all details data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectOverAllDetail;
	}

	@Override
	public List<Project> getProjectDetail(Integer projectId) throws DataServiceException {
		List<Project> projectDetail = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT  `projects`.`NAME`,`projects`.`DESCRIPTION`,`project_sprints`.`SPRINT_NAME`,`project_sprint_activities`.`ONLINE_ACTIVITY`,`project_sprint_activities`.`OFFLINE_ACTIVITY`,`quizzes`.`NAME` as 'Quiz name',`videos`.`NAME` as 'Video name',`videos`.`URL` ,`courses`.`NAME` as 'Course name' FROM `projects` JOIN `project_sprints`ON `projects`.`ID`=`project_sprints`.`PROJECT_ID` JOIN `project_sprint_activities` ON `project_sprints`.`ID`=`project_sprint_activities`.`PROJECT_SPRINT_ID` LEFT JOIN `videos` ON `project_sprint_activities`.`VIDEO_ID`=`videos`.`ID` LEFT JOIN`courses` ON `project_sprint_activities`.`COURSE_ID`=`courses`.`ID`LEFT JOIN `quizzes` ON `project_sprint_activities`.`QUIZ_ID`=`quizzes`.`ID` WHERE projects.`IS_ACTIVE`=TRUE AND projects.`ID`="
							+ projectId);
			projectDetail = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Projects details data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectDetail;
	}

	@Override
	public List<Project> getTotalProjectCount(Integer projectId) throws DataServiceException {
		List<Project> totalProjectCount = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT DISTINCT COUNT(projects.`ID`) as 'Project Count' FROM projects JOIN project_sprints ON projects.`ID`=project_sprints.`PROJECT_ID` JOIN project_sprint_activities ON project_sprints.`ID`=project_sprint_activities.`PROJECT_SPRINT_ID` WHERE projects.`IS_ACTIVE`=TRUE AND projects.`ID`="
							+ projectId);
			totalProjectCount = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("TotalProjectCount data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return totalProjectCount;
	}
}
