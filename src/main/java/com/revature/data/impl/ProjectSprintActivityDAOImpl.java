package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.ProjectSprintActivityDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.ProjectSprintActivity;
import com.revature.model.dto.ProjectSprintActivityDTO;

@Repository
public class ProjectSprintActivityDAOImpl implements ProjectSprintActivityDAO {

	private static Logger logger = Logger.getLogger(ProjectSprintActivityDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<ProjectSprintActivityDTO> getAllProjectSprintActivities() throws DataServiceException {
		List<ProjectSprintActivityDTO> projectSprintActivities = null;
		try {
			StringBuilder sb = new StringBuilder("select p.ID id,p.PROJECT_SPRINT_ID projectSprintId,p.VIDEO_ID videoId,p.COURSE_ID courseId,p.QUIZ_ID quizId,p.ONLINE_ACTIVITY onlineActivity,p.OFFLINE_ACTIVITY offlineActivity,p.DURATION_IN_MINUTES duration from project_sprint_activities p where p.IS_ACTIVE=true");
			projectSprintActivities =dataRetriver.retrieveBySQLAsJSON(sb.toString(),ProjectSprintActivityDTO.class);
			logger.info("ProjectSprintActivity data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectSprintActivities;
	}

	@Override
	public <E> ProjectSprintActivityDTO getProjectSprintActivityById(ProjectSprintActivity projectSprintActivity) throws DataServiceException {
		ProjectSprintActivityDTO projectSprintActivityById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT p.ID id,p.PROJECT_SPRINT_ID projectSprintId,p.VIDEO_ID videoId,p.COURSE_ID courseId,p.QUIZ_ID quizId,p.ONLINE_ACTIVITY onlineActivity,p.OFFLINE_ACTIVITY offlineActivity,p.DURATION_IN_MINUTES duration FROM project_sprint_activities p WHERE ID="+ projectSprintActivity.getId() + " and p.IS_ACTIVE=true");
			projectSprintActivityById = (ProjectSprintActivityDTO)dataRetriver.retrieveBySQLAsObject(sb.toString(), ProjectSprintActivityDTO.class);
			logger.info("projectSprintActivity  by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectSprintActivityById;
	}
}
