package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.DepartmentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Department;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	private static Logger logger = Logger.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/list/all")
	public List<Department> getActiveDepartmentsController() {
		List<Department> departments = null;
		try {
			logger.info("Getting the Departments data...");
			departments = departmentService.getAllDepartments();
			logger.info("Departments data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return departments;
	}

	@GetMapping("/list/id/{id}")
	public List<Department> getActiveDepartmentsController(@PathVariable("id") Integer departmentId) {
		List<Department> departmentsById = null;
		try {
			logger.info("Getting the departments by id data...");
			departmentsById = departmentService.getDepartmentById(departmentId);
			logger.info("departments by id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return departmentsById;
	}

	@GetMapping("/list/name/{name}")
	public List<Department> getActiveCategoriesController(@PathVariable("name") String departmentName) {
		List<Department> departmentsByName = null;
		try {
			logger.info("Getting the departments by name data...");
			departmentsByName = departmentService.getDepartmentByName(departmentName);
			logger.info("departments by name data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return departmentsByName;
	}

}
