package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.CollegeService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.College;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

	private static Logger logger = Logger.getLogger(CollegeController.class);

	@Autowired
	private CollegeService collegeService;

	@GetMapping("/list/all")
	public List<College> getActiveCollegesController() {
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

	@GetMapping("/list/id/{id}")
	public List<College> getActiveCollegesController(@PathVariable("id") int collegeId) {
		List<College> college = null;
		try {
			logger.info("Getting the categories data...");
			college = collegeService.getCollegeById(collegeId);
			logger.info("college data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return college;
	}

	@GetMapping("/list/name/{name}")
	public List<College> getActiveCollegeController(@PathVariable("name") String collegeName) {
		List<College> college = null;
		try {
			logger.info("Getting the categories data...");
			college = collegeService.getCollegeByName(collegeName);
			logger.info("college data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return college;
	}

}
