package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.UserService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.UserDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.College;
import com.revature.model.Department;
import com.revature.model.User;
import com.revature.model.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<UserDTO> getAllUsers() throws BusinessServiceException {
		List<UserDTO> users = null;
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
	public UserDTO getUserById(UserDTO userDTO) throws BusinessServiceException {
		UserDTO userById = new UserDTO();
		User user = new User();
		user.setId(userDTO.getId());
		try {
			userById = userDAO.getUserById(user);
			logger.info("User by id retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return userById;
	}

	@Override
	public UserDTO getUserByEmailId(UserDTO userDTO) throws BusinessServiceException {
		UserDTO userByEmailId = new UserDTO();
		User user = new User();
		user.setEmailId(userDTO.getEmailId());
		try {
			userByEmailId = userDAO.getUserByEmailId(user);
			logger.info("User by email id retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return userByEmailId;
	}

	@Override
	public List<UserDTO> getUsersByCollegeId(UserDTO userDTO) throws BusinessServiceException {
		List<UserDTO> userByCollegeId=null;
		User user = new User();
		College college=new College();
		college.setId(userDTO.getCollegeId());
		user.setCollegeId(college);
		try {
			userByCollegeId = userDAO.getUsersByCollegeId(user);
			logger.info("User by college id retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return userByCollegeId;
	}

	@Override
	public List<UserDTO> getUsersByDepartmentId(UserDTO userDTO) throws BusinessServiceException {
		List<UserDTO> userByDepartmentId = null;
		User user = new User();
		Department department=new Department();
		department.setId(userDTO.getDepartmentId());
		user.setDepartmentId(department);
		try {
			userByDepartmentId = userDAO.getUsersByDepartmentId(user);
			logger.info("User by department id retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return userByDepartmentId;
	}

	@Override
	public UserDTO getUserByLogin(UserDTO userDTO) throws BusinessServiceException {
		UserDTO userDTOObj = new UserDTO();
		try {
			User user = new User();
			user.setEmailId(userDTO.getEmailId());
			user.setPassword(userDTO.getPassword());
			userDTOObj = userDAO.getUserByLogin(user);
			logger.info("User retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return userDTOObj;
	}

	@Override
	public String updateUserPassword(UserDTO userDTO, String newPassword) throws BusinessServiceException {
		String msg = null;
		try {
			User user = new User();
			user.setEmailId(userDTO.getEmailId());
			user.setPassword(userDTO.getPassword());
			msg = userDAO.updateUserPassword(user, newPassword);
			logger.info("User password updated successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return msg;
	}

	@Override
	public String insertUserPassword(UserDTO userDTO) throws BusinessServiceException {
		String msg = null;
		try {
			User user = new User();
			user.setEmailId(userDTO.getEmailId());
			user.setPassword(userDTO.getPassword());
			msg = userDAO.insertUserPassword(user);
			logger.info("User password inserted successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return msg;
	}

}
