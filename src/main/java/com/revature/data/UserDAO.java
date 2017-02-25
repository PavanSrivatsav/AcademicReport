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

	public List<User> getUserById(Integer id) throws DataServiceException;

	public List<User> getUserByEmailId(String emailId) throws DataServiceException;

	public List<User> getUsersByCollegeId(Integer collegeId) throws DataServiceException;

	public List<User> getUsersByDepartmentId(Integer departmentId) throws DataServiceException;

	// public List<User> getValues() throws DataServiceException;

}
