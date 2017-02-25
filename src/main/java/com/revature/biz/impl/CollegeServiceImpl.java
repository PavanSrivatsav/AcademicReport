package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.CollegeService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CollegeDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.College;

@Service
public class CollegeServiceImpl implements CollegeService {
	private static Logger logger = Logger.getLogger(CollegeServiceImpl.class);

	@Autowired
	private CollegeDAO collegeDAO;

	@Override
	public List<College> getAllColleges() throws BusinessServiceException {
		List<College> colleges = null;
		try {
			colleges = collegeDAO.getAllColleges();
			logger.info("Colleges retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return colleges;
	}

	@Override
	public List<College> getCollegeById(Integer collegeId) throws BusinessServiceException {
		List<College> collegesById = null;
		try {
			collegesById = collegeDAO.getCollegeById(collegeId);
			logger.info("Colleges by id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return collegesById;
	}

	@Override
	public List<College> getCollegeByName(String collegeName) throws BusinessServiceException {
		List<College> collegesByName = null;
		try {
			collegesByName = collegeDAO.getCollegeByName(collegeName);
			logger.info("Colleges by name retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return collegesByName;
	}
}
