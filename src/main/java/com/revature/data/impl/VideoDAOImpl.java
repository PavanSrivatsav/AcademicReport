package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.VideoDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Video;

@Repository
public class VideoDAOImpl implements VideoDAO {

	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<Video> getAllVideos() throws DataServiceException {
		List<Video> videos = null;
		try {
			StringBuilder sb = new StringBuilder("select * from videos v where v.IS_ACTIVE=true");
			videos = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Users data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return videos;
	}

	@Override
	public List<Video> getVideoById(int videoId) throws DataServiceException {
		List<Video> videos = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from videos v where v.ID='" + videoId + "' and v.IS_ACTIVE=true");
			videos = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Users data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return videos;
	}

	@Override
	public List<Video> getVideoByName(String videoName) throws DataServiceException {
		List<Video> videos = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from videos v where v.NAME='" + videoName + "' and v.IS_ACTIVE=true");
			videos = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Users data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return videos;
	}

}
