package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.DepartmentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.DepartmentDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private static Logger logger = Logger.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public List<Department> getAllDepartments() throws BusinessServiceException {
		List<Department> departments = null;
		try {
			departments = departmentDAO.getAllDepartments();
			logger.info("Departments retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departments;
	}

	@Override
	public List<Department> getDepartmentById(Integer departmentId) throws BusinessServiceException {
		List<Department> departmentsById = null;
		try {
			departmentsById = departmentDAO.getDepartmentById(departmentId);
			logger.info("Departments by id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departmentsById;
	}

	@Override
	public List<Department> getDepartmentByName(String departmentName) throws BusinessServiceException {
		List<Department> departmentsByName = null;
		try {
			departmentsByName = departmentDAO.getDepartmentByName(departmentName);
			logger.info("Departments by id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departmentsByName;
	}
}
