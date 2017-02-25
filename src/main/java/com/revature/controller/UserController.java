package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.UserService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/list/all")
	public List<User> getActiveUsersController() {
		List<User> users = null;
		try {
			logger.info("Getting the Users data...");
			users = userService.getAllUsers();
			logger.info("Users data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return users;
	}

	@GetMapping("/list/id/{id}")
	public List<User> getActiveUsersByIdController(@PathVariable("id") Integer userId) {
		List<User> userById = null;
		try {
			logger.info("Getting the Users data...");
			userById = userService.getUserById(userId);
			logger.info("User data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return userById;
	}

	@GetMapping("/list/emailid/{emailid}/")
	public List<User> getActiveUsersByEmailIdController(@PathVariable("emailid") String userEmailId) {
		List<User> userByEmailId = null;
		try {
			logger.info("Getting the Users data...");
			userByEmailId = userService.getUserByEmailId(userEmailId);
			logger.info("User data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return userByEmailId;
	}

	@GetMapping("/list/college/id/{id}")
	public List<User> getActiveUsersByCollegeIdController(@PathVariable("id") Integer collegeId) {
		List<User> userByCollegeId = null;
		try {
			logger.info("Getting the Users by college id data...");
			userByCollegeId = userService.getUsersByCollegeId(collegeId);
			logger.info("Users by college id  data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return userByCollegeId;
	}

	@GetMapping("/list/department/id/{id}")
	public List<User> getActiveUsersDepartmentIdController(@PathVariable("id") Integer departmentId) {
		List<User> userByDepartmentId = null;
		try {
			logger.info("Getting the Users by department id data...");
			userByDepartmentId = userService.getUsersByDepartmentId(departmentId);
			logger.info("Users by department id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return userByDepartmentId;
	}

	/*
	 * public List<User> getUserController(){ List<User> users = null; try {
	 * ObjectMapper mapper=new ObjectMapper();
	 * mapper.enable(SerializationFeature.INDENT_OUTPUT);
	 * mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	 * logger.info("Getting the Users data..."); users =
	 * userService.getValues(); s=mapper.writeValueAsString(users);
	 * logger.info("Users data retrieval success."); } catch
	 * (BusinessServiceException e) { logger.error(e.getMessage(), e); throw new
	 * InvalidInputException(e.getMessage(), e); } catch (Exception e) {
	 * logger.error(e.getMessage(), e); throw new
	 * InternalException("System has some issue...", e); } return users; }
	 */

}
