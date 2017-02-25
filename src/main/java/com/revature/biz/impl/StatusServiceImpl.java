package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StatusService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StatusDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Status;

@Service
public class StatusServiceImpl implements StatusService {
	private static Logger logger = Logger.getLogger(StatusServiceImpl.class);

	@Autowired
	private StatusDAO statusDAO;

	@Override
	public List<Status> getAllStatus() throws BusinessServiceException {
		List<Status> status = null;
		try {
			status = statusDAO.getAllStatus();
			logger.info("Status retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return status;
	}

	@Override
	public List<Status> getStatusById(Integer id) throws BusinessServiceException {
		List<Status> statusById = null;
		try {
			statusById = statusDAO.getStatusById(id);
			logger.info("Status retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return statusById;
	}

	@Override
	public List<Status> getStatusByName(String name) throws BusinessServiceException {
		List<Status> statusByName = null;
		try {
			statusByName = statusDAO.getStatusByName(name);
			logger.info("Status by name retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return statusByName;
	}
}
