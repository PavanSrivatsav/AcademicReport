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
	public List<ProjectSprintActivity> getAllProjectSprintActivities() throws DataServiceException {
		List<ProjectSprintActivity> projectSprintActivities = null;
		try {
			StringBuilder sb = new StringBuilder("select * from project_sprint_activities p where p.IS_ACTIVE=true");
			projectSprintActivities = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("ProjectSprintActivitys data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectSprintActivities;
	}

	@Override
	public List<ProjectSprintActivity> getProjectSprintActivityById(int projectSprintActivityId)
			throws DataServiceException {
		return null;
	}
}