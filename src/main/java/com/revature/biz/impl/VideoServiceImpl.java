package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.VideoService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.VideoDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Video;

@Service
public class VideoServiceImpl implements VideoService{
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private  VideoDAO videoDAO;

	@Override
	public List<Video> getAllVideos() throws BusinessServiceException {
		List<Video> videos=null;
		try{
			videos=videoDAO.getAllVideos();
			logger.info("Videos retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return videos;
	}

	@Override
	public List<Video> getVideoById(int videoId) throws BusinessServiceException {
		List<Video> videos=null;
		try{
			videos=videoDAO.getVideoById(videoId);
			logger.info("Videos retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return videos;
	}

	@Override
	public List<Video> getVideoByName(String videoName) throws BusinessServiceException {
		List<Video> videos=null;
		try{
			videos=videoDAO.getVideoByName(videoName);
			logger.info("Videos retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return videos;
	}

}
