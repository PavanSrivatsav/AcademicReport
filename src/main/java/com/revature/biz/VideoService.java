package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Video;

public interface VideoService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<Video> getAllVideos() throws BusinessServiceException;

	List<Video> getVideoById(Integer videoId) throws BusinessServiceException;

	List<Video> getVideoByName(String videoName) throws BusinessServiceException;

}
