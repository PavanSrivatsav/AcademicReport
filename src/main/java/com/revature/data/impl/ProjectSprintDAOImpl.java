package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.ProjectSprintDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.ProjectSprint;

@Repository
public class ProjectSprintDAOImpl implements ProjectSprintDAO {

	private static Logger logger = Logger.getLogger(ProjectSprintDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<ProjectSprint> getAllProjectSprints() throws DataServiceException {
		List<ProjectSprint> projectSprints = null;
		try {
			StringBuilder sb = new StringBuilder("FROM ProjectSprint");
			projectSprints = dataRetriver.retrieveByHQL(sb.toString());
			logger.info("ProjectSprints data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectSprints;
	}
}
