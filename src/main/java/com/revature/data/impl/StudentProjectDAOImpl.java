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
		List<StudentProject> studentProject = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_projects where ID='"+studentProjectId+"'");
			studentProject = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProject;
	}

	@Override
	public List<StudentProject> getStudentProjectByStudentId(int studentId) throws DataServiceException {
		List<StudentProject> studentProject = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_projects where STUDENT_ID='"+studentId+"'");
			studentProject = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProject;
	}

	@Override
	public List<StudentProject> getStudentProjectByProjectId(int projectId) throws DataServiceException {
		List<StudentProject> studentProject = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_projects where PROJECT_ID='"+projectId+"'");
			studentProject = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("StudentProjects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProject;
	}
}
