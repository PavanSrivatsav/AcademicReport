package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StatusService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Status;

@RestController

public class StatusController {

	private static Logger logger = Logger.getLogger(StatusController.class);

	@Autowired
	private StatusService statusService;

	@RequestMapping("/status")
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
}
