package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.CollegeService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.College;

@RestController

public class CollegeController {

	private static Logger logger = Logger.getLogger(CollegeController.class);

	@Autowired
	private CollegeService collegeService;

	@RequestMapping("/colleges")
	public List<College> getCollegesController() {
		List<College> colleges = null;
		try {
			logger.info("Getting the colleges data...");
			colleges = collegeService.getAllColleges();
			logger.info("colleges data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return colleges;
	}
}
