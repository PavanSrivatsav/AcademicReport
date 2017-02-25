package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StatusService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Status;

@RestController
@RequestMapping("/status")
public class StatusController {

	private static Logger logger = Logger.getLogger(StatusController.class);

	@Autowired
	private StatusService statusService;

	@GetMapping("list/all")
	public List<Status> getStatusController() {
		List<Status> status = null;
		try {
			logger.info("Getting the Status data...");
			status = statusService.getAllStatus();
			logger.info("Status data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return status;
	}

	@GetMapping("list/id/{id}")
	public List<Status> getStatusByIdController(@PathVariable("id") Integer id) {
		List<Status> statusById = null;
		try {
			logger.info("Getting the Status by id data...");
			statusById = statusService.getStatusById(id);
			logger.info("Status by id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return statusById;
	}

	@GetMapping("list/name/{name}")
	public List<Status> getStatusByNameController(@PathVariable("name") String name) {
		List<Status> statusByName = null;
		try {
			logger.info("Getting the Status by name data...");
			statusByName = statusService.getStatusByName(name);
			logger.info("Status by name data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return statusByName;
	}
}
