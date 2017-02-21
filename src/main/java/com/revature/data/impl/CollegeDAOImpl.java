package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CollegeDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.College;

@Repository
public class CollegeDAOImpl implements CollegeDAO {

	private static Logger logger = Logger.getLogger(CollegeDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<College> getAllColleges() throws DataServiceException {
		List<College> colleges = null;
		try {
			StringBuilder sb = new StringBuilder("FROM College");
			colleges = dataRetriver.retrieveByHQL(sb.toString());
			logger.info("Colleges data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return colleges;
	}
}
