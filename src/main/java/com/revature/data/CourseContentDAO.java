package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.CourseContent;

public interface CourseContentDAO {
	public List<CourseContent> getAllCourseContents() throws DataServiceException;

	public List<CourseContent> getCourseContentById(int courseId) throws DataServiceException;

}
