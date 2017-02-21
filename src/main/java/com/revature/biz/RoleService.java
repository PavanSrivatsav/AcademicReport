package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Role;

public interface RoleService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<Role> getAllRoles() throws BusinessServiceException;
}
