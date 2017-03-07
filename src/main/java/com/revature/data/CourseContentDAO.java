package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.CourseContent;
import com.revature.model.dto.CourseContentDTO;

public interface CourseContentDAO {

	public List<CourseContentDTO> getAllCourseContents() throws DataServiceException;

	public <E> CourseContentDTO getCourseContentById(CourseContent courseContent) throws DataServiceException;

	public List <CourseContentDTO> getCourseContentByCourseId(CourseContent courseContent) throws DataServiceException;

	public <E> CourseContentDTO getCourseContentByVideoId(CourseContent courseContent) throws DataServiceException;

}
