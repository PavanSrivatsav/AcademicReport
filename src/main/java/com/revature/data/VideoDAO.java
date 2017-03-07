package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;

import com.revature.model.Video;
import com.revature.model.dto.VideoDTO;

public interface VideoDAO {
	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<VideoDTO> getAllVideos() throws DataServiceException;

	public <E> VideoDTO getVideoById(Video video) throws DataServiceException;

	public <E> VideoDTO getVideoByName(Video video) throws DataServiceException;

}
