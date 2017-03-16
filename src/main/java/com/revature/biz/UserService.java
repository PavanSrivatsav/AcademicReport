package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.UserDTO;

public interface UserService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<UserDTO> getAllUsers() throws BusinessServiceException;

	UserDTO getUserById(UserDTO userDTO) throws BusinessServiceException;

	UserDTO getUserByEmailId(UserDTO userDTO) throws BusinessServiceException;

	List<UserDTO> getUsersByCollegeId(UserDTO userDTO) throws BusinessServiceException;

	List<UserDTO> getUsersByDepartmentId(UserDTO userDTO) throws BusinessServiceException;

	UserDTO getUserByLogin(UserDTO userDTO) throws BusinessServiceException;

	Object updateUserPassword(UserDTO userDTO, String newPassword) throws BusinessServiceException;

	String insertUserPassword(UserDTO userDTO) throws BusinessServiceException;
	
}
