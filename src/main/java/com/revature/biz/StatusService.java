package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Status;

public interface StatusService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<Status> getAllStatus() throws BusinessServiceException;

	List<Status> getStatusById(int statusId) throws BusinessServiceException;

	List<Status> getStatusByName(String statusName) throws BusinessServiceException;
}
