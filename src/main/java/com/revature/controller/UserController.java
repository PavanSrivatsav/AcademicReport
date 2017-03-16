package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.UserService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.dto.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	// @GetMapping("/login/{emailId}/{password}")
	// public UserDTO loginController(@PathVariable("emailId") String emailId,
	// @PathVariable("password") String password) {
	// UserDTO userDTO = new UserDTO();
	// userDTO.setEmailId(emailId);
	// userDTO.setPassword(password);
	// try {
	// logger.info("Getting the Users data...");
	// userDTO = userService.getUserByLogin(userDTO);
	// logger.info("Users data retrieval success.");
	// } catch (BusinessServiceException e) {
	// logger.error(e.getMessage(), e);
	// throw new InvalidInputException(e.getMessage(), e);
	// } catch (Exception e) {
	// logger.error(e.getMessage(), e);
	// throw new InternalException("System has some issue...", e);
	// }
	// return userDTO;
	// }

	// Testing
	//
	@PostMapping("/login")
	public UserDTO loginController(@RequestParam("emailId") String emailId, @RequestParam("password") String password) {
		UserDTO userDTO = new UserDTO();

		userDTO.setEmailId(emailId);
		userDTO.setPassword(password);
		try {
			logger.info("Getting the Users data...");
			userDTO = userService.getUserByLogin(userDTO);
			logger.info("Users data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return userDTO;
	}

	/*
	 * @GetMapping(
	 * "update/emailId/{emailId}/password/{password}/newPassword/{newPassword}")
	 * public String passwordUpdateController(@PathVariable("emailId") String
	 * emailId,
	 * 
	 * @PathVariable("password") String password, @PathVariable("newPassword")
	 * String newPassword) { String user = null; UserDTO userDTO = new
	 * UserDTO(); userDTO.setEmailId(emailId); userDTO.setPassword(password);
	 * try { user = userService.updateUserPassword(userDTO, newPassword);
	 * logger.info("Password updated."); } catch (Exception e) {
	 * logger.error(e.getMessage(), e); throw new
	 * InternalException("System has some issue...", e); } return user; }
	 */

	// akka

	// @PostMapping("/update/newPassword/{newPassword}")
	// public String updateController1(@PathVariable ("newPassword") String
	// newPassword,@RequestBody UserDTO userDTOParam) {
	// String msg=null;
	// try {
	// logger.info("Getting the Users data...");
	// msg = userService.updateUserPassword(userDTOParam, newPassword);
	// logger.info("Users data retrieval success.");
	// } catch (BusinessServiceException e) {
	// logger.error(e.getMessage(), e);
	// throw new InvalidInputException(e.getMessage(), e);
	// } catch (Exception e) {
	// logger.error(e.getMessage(), e);
	// throw new InternalException("System has some issue...", e);
	// }
	// return msg;
	// }

	// akka wrking
	// @PostMapping("/update")
	// public String updateController2(@RequestParam("newPassword") String
	// newPassword,@RequestBody UserDTO userDTOParam) {
	// String msg=null;
	// try {
	// logger.info("Getting the Users data...");
	// msg = userService.updateUserPassword(userDTOParam, newPassword);
	// logger.info("Users data retrieval success.");
	// } catch (BusinessServiceException e) {
	// logger.error(e.getMessage(), e);
	// throw new InvalidInputException(e.getMessage(), e);
	// } catch (Exception e) {
	// logger.error(e.getMessage(), e);
	// throw new InternalException("System has some issue...", e);
	// }
	// return msg;
	// }

	// Testing

	@PostMapping("/update")
	public Object updateController2(@RequestParam("newPassword") String newPassword,
			@RequestParam("emailId") String emailId, @RequestParam("password") String password) {
		Object msg = null;
		UserDTO userDTO = new UserDTO();

		userDTO.setEmailId(emailId);
		userDTO.setPassword(password);
		System.out.println("new" + newPassword + "email" + emailId + "pass" + password);
		try {
			logger.info("Getting the Users data...");
			msg = userService.updateUserPassword(userDTO, newPassword);

			logger.info("Users data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return msg;
	}

	@GetMapping("emailId/{emailId}/password/{password}")
	public String passwordInsertController(@PathVariable("password") String password,
			@PathVariable("emailId") String emailId) {
		String user = null;
		UserDTO userDTO = new UserDTO();
		userDTO.setEmailId(emailId);
		userDTO.setPassword(password);
		try {
			logger.info("encrypting...");
			user = userService.insertUserPassword(userDTO);
			logger.info("Password inserted.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return user;
	}

	@GetMapping("/list/all")
	public List<UserDTO> getActiveUsersController() {
		List<UserDTO> users = null;
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
	public UserDTO getActiveUsersByIdController(@PathVariable("id") Integer userId) {
		UserDTO userById = null;
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userId);
		try {
			logger.info("Getting the Users data...");
			userById = userService.getUserById(userDTO);
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
	public UserDTO getActiveUsersByEmailIdController(@PathVariable("emailid") String userEmailId) {
		UserDTO userByEmailId = null;
		UserDTO userDTO = new UserDTO();
		userDTO.setEmailId(userEmailId);
		try {
			logger.info("Getting the Users data...");
			userByEmailId = userService.getUserByEmailId(userDTO);
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
	public List<UserDTO> getActiveUsersByCollegeIdController(@PathVariable("id") Integer collegeId) {
		List<UserDTO> userByCollegeId = null;
		UserDTO userDTO = new UserDTO();
		userDTO.setCollegeId(collegeId);
		try {
			logger.info("Getting the Users by college id data...");
			userByCollegeId = userService.getUsersByCollegeId(userDTO);
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
	public List<UserDTO> getActiveUsersDepartmentIdController(@PathVariable("id") Integer departmentId) {
		List<UserDTO> userByDepartmentId = null;
		UserDTO userDTO = new UserDTO();
		userDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the Users by department id data...");
			userByDepartmentId = userService.getUsersByDepartmentId(userDTO);
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

}
