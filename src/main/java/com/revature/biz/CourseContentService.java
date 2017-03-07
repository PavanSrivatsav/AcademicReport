package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.CourseContentDTO;

public interface CourseContentService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<CourseContentDTO> getAllCourseContents() throws BusinessServiceException;

	CourseContentDTO getCourseContentById(CourseContentDTO courseContentDTO) throws BusinessServiceException;

	List<CourseContentDTO> getCourseContentByCourseId(CourseContentDTO courseContentDTO) throws BusinessServiceException;

	CourseContentDTO getCourseContentByVideoId(CourseContentDTO courseContentDTO) throws BusinessServiceException;

}
