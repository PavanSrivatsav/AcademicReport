package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.UserDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<User> getAllUsers() throws DataServiceException {
		List<User> users = null;
		try {
			StringBuilder sb = new StringBuilder("select * from users u where u.IS_ACTIVE=true");
			users = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Users data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return users;
	}

	@Override
	public List<User> getUserById(Integer userId) throws DataServiceException {
		List<User> userById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from users u where u.ID='" + userId + "' and u.IS_ACTIVE=true");
			userById = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("User by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userById;
	}

	@Override
	public List<User> getUserByEmailId(String userEmailId) throws DataServiceException {
		List<User> userByEmailId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from users u where u.EMAIL_ID='" + userEmailId + "' and u.IS_ACTIVE=true");
			userByEmailId = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("User by email id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userByEmailId;
	}

	@Override
	public List<User> getUsersByCollegeId(Integer collegeId) throws DataServiceException {
		List<User> userByCollegeId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from users u where u.COLLEGE_ID='" + collegeId + "' and u.IS_ACTIVE=true");
			userByCollegeId = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Users by college id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userByCollegeId;
	}

	@Override
	public List<User> getUsersByDepartmentId(Integer departmentId) throws DataServiceException {
		List<User> userByDepartmentId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from users u where u.DEPARTMENT_ID='" + departmentId + "' and u.IS_ACTIVE=true");
			userByDepartmentId = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Users by department id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userByDepartmentId;
	}

	/*
	 * @Override public List<User> getValues() throws DataServiceException {
	 * List<User> users = null; try { StringBuilder sb = new
	 * StringBuilder("SELECT u.NAME AS User_name,r.NAME AS Role,c.NAME AS College_name,d.NAME AS Department_name FROM users u JOIN seed_roles r ON u.ROLE_ID=r.ID JOIN colleges c ON u.COLLEGE_ID=c.ID JOIN seed_departments d ON u.DEPARTMENT_ID=d.ID where u.IS_ACTIVE=true"
	 * ); users = dataRetriver.retrieveBySQL(sb.toString());
	 * logger.info("Users data retrieval success.."); } catch
	 * (DataAccessException e) { logger.error(e.getMessage(), e); throw new
	 * DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"),
	 * e); } return users; }
	 */

}
