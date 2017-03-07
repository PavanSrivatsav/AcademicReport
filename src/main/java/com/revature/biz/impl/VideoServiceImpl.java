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
import com.revature.model.dto.VideoDTO;

@Service
public class VideoServiceImpl implements VideoService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private VideoDAO videoDAO;

	@Override
	public List<VideoDTO> getAllVideos() throws BusinessServiceException {
		List<VideoDTO> videos = null;
		try {
			videos = videoDAO.getAllVideos();
			logger.info("Videos retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return videos;
	}

	@Override
	public VideoDTO getVideoById(VideoDTO videoDTO) throws BusinessServiceException {
		VideoDTO videoById = new VideoDTO();
		Video video = new Video();
		video.setId(videoDTO.getId());
		try {
			videoById = videoDAO.getVideoById(video);
			logger.info("Videos retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return videoById;
	}

	@Override
	public VideoDTO getVideoByName(VideoDTO videoDTO) throws BusinessServiceException {
		VideoDTO videoByName = new VideoDTO();
		Video video= new Video();
		video.setName(videoDTO.getName());
		try {
			videoByName = videoDAO.getVideoByName(video);
			logger.info("Videos retrived successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return videoByName;
	}

}
