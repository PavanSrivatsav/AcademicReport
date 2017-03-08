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
import com.revature.model.College;
import com.revature.model.Project;
import com.revature.model.dto.ProjectDTO;

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
	public List<ProjectDTO> getAllProjects() throws DataServiceException {
		List<ProjectDTO> projects = null;
		try {
			StringBuilder sb = new StringBuilder("select p.ID id,p.NAME name,p.CATEGORY_ID categoyId,p.DESCRIPTION description,p.DURATION_IN_MINUTES duration,p.IS_ACTIVE isActive from projects p where p.IS_ACTIVE=true");
			projects = dataRetriver.retrieveBySQLAsJSON(sb.toString(),ProjectDTO.class);
			logger.info("Projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projects;
	}

	@Override
	public <E> ProjectDTO getProjectById(Project project) throws DataServiceException {
		ProjectDTO projectById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select p.ID id, p.NAME name, p.CATEGORY_ID categoyId, p.DESCRIPTION description, p.DURATION_IN_MINUTES duration, p.IS_ACTIVE isActive from projects p where p.ID='"+project.getId()+"' and p.IS_ACTIVE=true");
			projectById = (ProjectDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(),ProjectDTO.class);
			logger.info("Projects by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectById;
	}

	@Override
	public <E> ProjectDTO getProjectByName(Project project) throws DataServiceException {
		ProjectDTO projectByName = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select p.ID id,p.NAME name,p.CATEGORY_ID categoyId,p.DESCRIPTION description,p.DURATION_IN_MINUTES duration,p.IS_ACTIVE isActive from projects p where p.NAME='"+project.getName()+"' and p.IS_ACTIVE=true");
			projectByName = (ProjectDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(),ProjectDTO.class);
			logger.info("Projects by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectByName;
	}

	@Override
	public List<ProjectDTO> getProjectByCategoryId(Project project) throws DataServiceException {
		List<ProjectDTO> projectByCategoryId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select p.ID id,p.NAME name,p.CATEGORY_ID categoyId,p.DESCRIPTION description,p.DURATION_IN_MINUTES duration,p.IS_ACTIVE isActive from projects p where p.CATEGORY_ID='" + project.getCategoy().getId() + "' and p.IS_ACTIVE=true");
			projectByCategoryId = dataRetriver.retrieveBySQLAsJSON(sb.toString(),ProjectDTO.class);
			logger.info("Projects by category id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectByCategoryId;
	}

	@Override
	public List<ProjectDTO> getProjectOverAllDetail(College college) throws DataServiceException {
		List<ProjectDTO> projectOverAllDetail = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT p.ID id,p.NAME name,p.DESCRIPTION description FROM projects p WHERE p.ID IN (SELECT DISTINCT projects.`ID` FROM `student_projects` JOIN `projects` ON `projects`.`ID`=`student_projects`.`PROJECT_ID` JOIN `students` ON students.`ID`=student_projects.`STUDENT_ID` WHERE `students`.`IS_ACTIVE`=TRUE AND projects.`IS_ACTIVE`=TRUE AND `students`.`COLLEGE_ID`= '"
							+ college.getId() + "' )");
			projectOverAllDetail = dataRetriver.retrieveBySQLAsJSON(sb.toString(),ProjectDTO.class);
			logger.info("Projects over all details data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectOverAllDetail;
	}

	@Override
	public List<ProjectDTO> getProjectDetail(Project project) throws DataServiceException {
		List<ProjectDTO> projectDetail = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT id id,project_name name,description description,sprint_name sprintName,online_activity onlineActivity,offline_activity offlineActivity,quiz_name quizName,video_name videoName,url url,course_name courseName FROM vw_project_activity WHERE id="+ project.getId());
			projectDetail =dataRetriver.retrieveBySQLAsJSON(sb.toString(),ProjectDTO.class);
			logger.info("Projects details data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projectDetail;
	}

	@Override
	public List<ProjectDTO> getTotalProjectCount(Project project) throws DataServiceException {
		List<ProjectDTO> totalProjectCount = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT id id,project_count cunt FROM vw_project_activity_count WHERE ID="
							+ project.getId());
			totalProjectCount =dataRetriver.retrieveBySQLAsJSON(sb.toString(), ProjectDTO.class);
			logger.info("TotalProjectCount data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return totalProjectCount;
	}
}
