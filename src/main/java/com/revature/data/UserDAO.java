package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.User;
import com.revature.model.dto.UserDTO;

public interface UserDAO {
	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<UserDTO> getAllUsers() throws DataServiceException;

	public <E> UserDTO getUserById(User user) throws DataServiceException;

	public <E> UserDTO getUserByEmailId(User user) throws DataServiceException;

	public List<UserDTO> getUsersByCollegeId(User user) throws DataServiceException;

	public List<UserDTO> getUsersByDepartmentId(User user) throws DataServiceException;

	public <E> UserDTO getUserByLogin(User user) throws DataServiceException;

	public String insertUserPassword(User user) throws DataServiceException;

	public Object updateUserPassword(User user, String newPassword) throws DataServiceException;

}
