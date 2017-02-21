package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Status;

public interface StatusDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<Status> getAllStatus() throws DataServiceException;

}
