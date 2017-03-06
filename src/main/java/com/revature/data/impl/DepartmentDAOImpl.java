package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.DepartmentDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	private static Logger logger = Logger.getLogger(DepartmentDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<Department> getAllDepartments() throws DataServiceException {
		List<Department> departments = null;
		try {
			StringBuilder sb = new StringBuilder("select * from seed_departments d where d.IS_ACTIVE=true");
			departments = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Departments data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return departments;
	}

	@Override
	public List<Department> getDepartmentById(Integer id) throws DataServiceException {
		List<Department> departmentsById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from seed_departments d where ID=" + id + " and d.IS_ACTIVE=true");
			departmentsById = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Departments by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return departmentsById;
	}

	@Override
	public List<Department> getDepartmentByName(String departmentName) throws DataServiceException {
		List<Department> departmentsByName = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from seed_departments d where NAME='" + departmentName + "' and d.IS_ACTIVE=true");
			departmentsByName = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Departments by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return departmentsByName;
	}
}
