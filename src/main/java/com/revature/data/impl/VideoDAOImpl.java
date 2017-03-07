package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.VideoDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Video;
import com.revature.model.dto.VideoDTO;

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
	@Autowired
	private DataModifier dataModifier;

	public DataModifier getDataModifier() {
		return dataModifier;
	}

	public void setDataModifier(DataModifier dataModifier) {
		this.dataModifier = dataModifier;
	}


	@Override
	public List<VideoDTO> getAllVideos() throws DataServiceException {
		List<VideoDTO> videos = null;
		try {
			StringBuilder sb = new StringBuilder("select v.ID id,v.NAME name,v.URL url,v.TRANSCRIPT_FILENAME transcriptFilename,v.DURATION_IN_MINUTES duration,v.IS_ACTIVE isActive from videos v where v.IS_ACTIVE=true");
			videos = dataRetriver.retrieveBySQLAsJSON(sb.toString(),VideoDTO.class);
			logger.info("Users data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return videos;
	}


	@Override
	public <E> VideoDTO getVideoById(Video video) throws DataServiceException {
		VideoDTO videos = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select v.ID id,v.NAME name,v.URL url,v.TRANSCRIPT_FILENAME transcriptFilename,v.DURATION_IN_MINUTES duration,v.IS_ACTIVE isActive from videos v where v.ID='" + video.getId() + "' and v.IS_ACTIVE=true");
			videos =(VideoDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(),VideoDTO.class);
			logger.info("Video data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return videos;
	}

	@Override
	public <E> VideoDTO getVideoByName(Video video) throws DataServiceException {
		VideoDTO videos = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select v.ID id,v.NAME name,v.URL url,v.TRANSCRIPT_FILENAME transcriptFilename,v.DURATION_IN_MINUTES duration,v.IS_ACTIVE isActive from videos v where v.NAME='" +video.getName() + "' and v.IS_ACTIVE=true");
			videos = (VideoDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(),VideoDTO.class);
			logger.info("Video data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return videos;
	}

}
