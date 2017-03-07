package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.VideoDTO;

public interface VideoService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 
	 */
	List<VideoDTO> getAllVideos() throws BusinessServiceException;

	VideoDTO getVideoById(VideoDTO videoDTO) throws BusinessServiceException;

	VideoDTO getVideoByName(VideoDTO videoDTO) throws BusinessServiceException;

}
