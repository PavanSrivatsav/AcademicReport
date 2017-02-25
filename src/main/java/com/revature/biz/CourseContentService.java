package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.CourseContent;

public interface CourseContentService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<CourseContent> getAllCourseContents() throws BusinessServiceException;

	List<CourseContent> getCourseContentById(Integer id) throws BusinessServiceException;

	List<CourseContent> getCourseContentByCourseId(Integer courseId) throws BusinessServiceException;

	List<CourseContent> getCourseContentByVideoId(Integer videoId) throws BusinessServiceException;

}
