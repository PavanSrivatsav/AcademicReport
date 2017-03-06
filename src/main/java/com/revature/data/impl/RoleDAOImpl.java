package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.RoleDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	private static Logger logger = Logger.getLogger(RoleDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<Role> getAllRoles() throws DataServiceException {
		List<Role> roles = null;
		try {
			StringBuilder sb = new StringBuilder("select * from seed_roles");
			roles = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Roles data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return roles;
	}

	@Override
	public List<Role> getRoleById(Integer id) throws DataServiceException {
		List<Role> roleById = null;
		try {
			StringBuilder sb = new StringBuilder("select * from seed_roles where ID=" + id);
			roleById = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Role by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return roleById;
	}

	@Override
	public List<Role> getRoleByName(String name) throws DataServiceException {
		List<Role> roleByName = null;
		try {
			StringBuilder sb = new StringBuilder("select * from seed_roles where Name='" + name + "'");
			roleByName = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Role by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return roleByName;
	}
}
