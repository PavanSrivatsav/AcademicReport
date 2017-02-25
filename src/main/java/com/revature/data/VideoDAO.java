package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Video;

public interface VideoDAO {
	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<Video> getAllVideos() throws DataServiceException;

	public List<Video> getVideoById(int videoId) throws DataServiceException;
	
	public List<Video> getVideoByName(String videoName) throws DataServiceException;

}
