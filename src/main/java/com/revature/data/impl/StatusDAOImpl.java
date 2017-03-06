package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StatusDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Status;

@Repository
public class StatusDAOImpl implements StatusDAO {

	private static Logger logger = Logger.getLogger(StatusDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<Status> getAllStatus() throws DataServiceException {
		List<Status> status = null;
		try {
			StringBuilder sb = new StringBuilder("select * from seed_status");
			status = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Status data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return status;
	}

	@Override
	public List<Status> getStatusById(Integer id) throws DataServiceException {
		List<Status> statusById = null;
		try {
			StringBuilder sb = new StringBuilder("select * from seed_status where ID=" + id);
			statusById = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Status by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return statusById;
	}

	@Override
	public List<Status> getStatusByName(String name) throws DataServiceException {
		List<Status> statusByName = null;
		try {
			StringBuilder sb = new StringBuilder("select * from seed_status where Name='" + name + "'");
			statusByName = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Status by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return statusByName;
	}
}
