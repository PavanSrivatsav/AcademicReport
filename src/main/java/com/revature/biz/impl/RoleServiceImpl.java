package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.RoleService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.RoleDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Role;

@Service
public class RoleServiceImpl implements RoleService {
	private static Logger logger = Logger.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleDAO roleDAO;

	@Override
	public List<Role> getAllRoles() throws BusinessServiceException {
		List<Role> roles = null;
		try {
			roles = roleDAO.getAllRoles();
			logger.info("Roles retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return roles;
	}
}
