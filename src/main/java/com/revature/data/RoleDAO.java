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

}
