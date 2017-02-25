package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.VideoService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Video;

@RestController

public class VideoController {

	private static Logger logger = Logger.getLogger(QuizController.class);

	@Autowired
	private VideoService videoService;
	
	@GetMapping("/list/all")
	public List<Video> getActiveCoursesController() {
		List<Video> videos = null;
		try {
			logger.info("Getting the courses data...");
			videos = videoService.getAllVideos();
			logger.info("videos data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return videos;
	}
	
	@GetMapping("/list/id/{id}")
	public List<Video> getActiveCoursesController(@PathVariable("id") int videoId) {
		List<Video> video = null;
		try {
			logger.info("Getting the courses data...");
			video = videoService.getVideoById(videoId);
			logger.info("video data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return video;
	}

	@GetMapping("/list/id/{name}")
	public List<Video> getActiveCoursesController(@PathVariable("name") String videoName) {
		List<Video> video = null;
		try {
			logger.info("Getting the courses data...");
			video = videoService.getVideoByName(videoName);
			logger.info("video data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return video;
	}

}
