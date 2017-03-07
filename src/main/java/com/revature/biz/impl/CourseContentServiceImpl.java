package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.CourseContentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CourseContentDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Course;
import com.revature.model.CourseContent;
import com.revature.model.Video;
import com.revature.model.dto.CourseContentDTO;

@Service
public class CourseContentServiceImpl implements CourseContentService {

	private static Logger logger = Logger.getLogger(CourseContentServiceImpl.class);

	@Autowired
	private CourseContentDAO courseContentDAO;

	@Override
	public List<CourseContentDTO> getAllCourseContents() throws BusinessServiceException {
		List<CourseContentDTO> courseContents = null;
		try {
			courseContents = courseContentDAO.getAllCourseContents();
			logger.info("Course contents retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courseContents;
	}


	@Override
	public CourseContentDTO getCourseContentById(CourseContentDTO courseContentDTO) throws BusinessServiceException {
		CourseContentDTO courseContentsById = new CourseContentDTO();
		CourseContent courseContent = new CourseContent();
		courseContent.setId(courseContentDTO.getId());
		
		try {
			courseContentsById = courseContentDAO.getCourseContentById(courseContent);
			logger.info("Course contents by id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courseContentsById;
	}

	@Override
	public List<CourseContentDTO> getCourseContentByCourseId(CourseContentDTO courseContentDTO) throws BusinessServiceException {
		List<CourseContentDTO> courseContentsByCourseId =  null;
		CourseContent courseContent = new CourseContent();
		Course course = new Course();
		course.setId(courseContentDTO.getCourseId());
		courseContent.setCourse(course);
		courseContent.setId(courseContentDTO.getCourseId());
		try {
			courseContentsByCourseId = courseContentDAO.getCourseContentByCourseId(courseContent);
			logger.info("Course contents by course id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courseContentsByCourseId;
	}

	@Override
	public CourseContentDTO getCourseContentByVideoId(CourseContentDTO courseContentDTO) throws BusinessServiceException {
		CourseContentDTO courseContentsByVideoId = new CourseContentDTO();
		CourseContent courseContent = new CourseContent();
		Video video = new Video();
		video.setId(courseContentDTO.getVideoId());
		courseContent.setVideo(video);
		
		try {
			courseContentsByVideoId = courseContentDAO.getCourseContentByVideoId(courseContent);
			logger.info("Course contents by video id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courseContentsByVideoId;
	}

}
