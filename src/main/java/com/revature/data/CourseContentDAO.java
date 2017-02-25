package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.CourseContent;

public interface CourseContentDAO {

	public List<CourseContent> getAllCourseContents() throws DataServiceException;

	public List<CourseContent> getCourseContentById(Integer Id) throws DataServiceException;

	public List<CourseContent> getCourseContentByCourseId(Integer courseId) throws DataServiceException;

	public List<CourseContent> getCourseContentByVideoId(Integer videoId) throws DataServiceException;

}
