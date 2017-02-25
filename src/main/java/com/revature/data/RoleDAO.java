package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Role;

public interface RoleDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<Role> getAllRoles() throws DataServiceException;

	public List<Role> getRoleById(Integer roleId) throws DataServiceException;

	public List<Role> getRoleByName(String roleName) throws DataServiceException;

}
