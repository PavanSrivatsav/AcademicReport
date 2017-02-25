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
			departments = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Departments data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return departments;
	}

	@Override
	public List<Department> getDepartmentById(int departmentId) throws DataServiceException {
		return null;
	}

	@Override
	public List<Department> getDepartmentByName(String departmentName) throws DataServiceException {
		return null;
	}
}
