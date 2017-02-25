package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.RoleService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Role;

@RestController
@RequestMapping("/roles")
public class RoleController {

	private static Logger logger = Logger.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@RequestMapping("/list/all")
	public List<Role> getRolesController() {
		List<Role> roles = null;
		try {
			logger.info("Getting the roles data...");
			roles = roleService.getAllRoles();
			logger.info("roles data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return roles;
	}

	@RequestMapping("/list/id/{id}")
	public List<Role> getRolesByIdController(@PathVariable("id") Integer id) {
		List<Role> roleById = null;
		try {
			logger.info("Getting the role by id data...");
			roleById = roleService.getRoleById(id);
			logger.info("role by id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return roleById;
	}

	@RequestMapping("/list/name/{name}")
	public List<Role> getRoleByNameController(@PathVariable("name") String name) {
		List<Role> roleByName = null;
		try {
			logger.info("Getting the role by name data...");
			roleByName = roleService.getRoleByName(name);
			logger.info("role by name data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return roleByName;
	}

}
