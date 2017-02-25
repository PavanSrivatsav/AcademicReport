package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.User;

public interface UserService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<User> getAllUsers() throws BusinessServiceException;

	List<User> getUserById(int userId) throws BusinessServiceException;

	List<User> getUserByEmailId(String userEmailId) throws BusinessServiceException;
	
	// List<User> getValues() throws BusinessServiceException;
}
