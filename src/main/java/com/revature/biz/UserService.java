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

	List<User> getUserById(Integer userId) throws BusinessServiceException;

	List<User> getUserByEmailId(String userEmailId) throws BusinessServiceException;

	List<User> getUsersByCollegeId(Integer collegeId) throws BusinessServiceException;

	List<User> getUsersByDepartmentId(Integer departmentId) throws BusinessServiceException;

	List<User> getUserByLogin(String userEmailId, String password) throws BusinessServiceException;

}
