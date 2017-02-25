package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Department;

public interface DepartmentDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<Department> getAllDepartments() throws DataServiceException;

	public List<Department> getDepartmentById(Integer departmentId) throws DataServiceException;

	public List<Department> getDepartmentByName(String departmentName) throws DataServiceException;

}
