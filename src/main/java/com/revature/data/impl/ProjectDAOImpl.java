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

}
