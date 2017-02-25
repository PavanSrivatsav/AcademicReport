package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.User;

public interface UserDAO {
	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<User> getAllUsers() throws DataServiceException;

	public List<User> getUserById(int userId) throws DataServiceException;

	public List<User> getUserByEmailId(String userEmailId) throws DataServiceException;

	// public List<User> getValues() throws DataServiceException;

}
