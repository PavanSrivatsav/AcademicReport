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
	private  UserDAO userDAO;
	
	@Override
	public List<User> getAllUsers() throws BusinessServiceException {
		List<User> users=null;
		try{
			users=userDAO.getAllUsers();
			logger.info("Users retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return users;
	}

	@Override
	public List<User> getUserById(int userId) throws BusinessServiceException {
		List<User> users=null;
		try{
			users=userDAO.getUserById(userId);
			logger.info("User retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return users;
	}

	@Override
	public List<User> getUserByEmailId(String userEmailId) throws BusinessServiceException {
		List<User> users=null;
		try{
			users=userDAO.getUserByEmailId(userEmailId);
			logger.info("User retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return users;
	}

/*	
	@Override
	public List<User> getValues() throws BusinessServiceException {
		List<User> users=null;
		try{
			users=userDAO.getValues();
			logger.info("Users retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return users;
	}
*/

}
