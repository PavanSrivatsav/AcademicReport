package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.UserService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.UserDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.User;

@Service
public class UserServiceImpl implements UserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getAllUsers() throws BusinessServiceException {
		List<User> users = null;
		try {
			users = userDAO.getAllUsers();
			logger.info("Users retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return users;
	}

	@Override
	public List<User> getUserById(Integer userId) throws BusinessServiceException {
		List<User> userById = null;
		try {
			userById = userDAO.getUserById(userId);
			logger.info("User by id retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return userById;
	}

	@Override
	public List<User> getUserByEmailId(String userEmailId) throws BusinessServiceException {
		List<User> userByEmailId = null;
		try {
			userByEmailId = userDAO.getUserByEmailId(userEmailId);
			logger.info("User by email id retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return userByEmailId;
	}

	@Override
	public List<User> getUsersByCollegeId(Integer collegeId) throws BusinessServiceException {
		List<User> userByCollegeId = null;
		try {
			userByCollegeId = userDAO.getUsersByCollegeId(collegeId);
			logger.info("User by college id retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return userByCollegeId;
	}

	@Override
	public List<User> getUsersByDepartmentId(Integer departmentId) throws BusinessServiceException {
		List<User> userByDepartmentId = null;
		try {
			userByDepartmentId = userDAO.getUsersByDepartmentId(departmentId);
			logger.info("User by department id retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return userByDepartmentId;
	}

	@Override
	public List<User> getUserByLogin(String userEmailId, String password) throws BusinessServiceException {
		List<User> user = null;
		try {
			user = userDAO.getUserByLogin(userEmailId, password);
			logger.info("User retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return user;
	}

	/*
	 * @Override public List<User> getValues() throws BusinessServiceException {
	 * List<User> users=null; try{ users=userDAO.getValues();
	 * logger.info("Users retrived successfully"); } catch (DataServiceException
	 * e) { logger.error(e.getMessage(), e); throw new
	 * BusinessServiceException(e.getMessage(), e); } return users; }
	 */

}
