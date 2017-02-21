package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Department;

public interface DepartmentService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<Department> getAllDepartments() throws BusinessServiceException;
}
