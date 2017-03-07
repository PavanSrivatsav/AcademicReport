package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.CollegeDTO;
import com.revature.model.dto.CourseDTO;

public interface CourseService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<CourseDTO> getAllCourses() throws BusinessServiceException;

	CourseDTO getCoursesById(CourseDTO courseDTO) throws BusinessServiceException;

	CourseDTO getCourseByName(CourseDTO courseDTO) throws BusinessServiceException;

	List<CourseDTO> getCourseByCategoryId(CourseDTO courseDTO) throws BusinessServiceException;

	List<CollegeDTO> getCourseOverAllDetail(CollegeDTO collegeDTO) throws BusinessServiceException;

	List<CourseDTO> getCourseDetail(CourseDTO courseDTO) throws BusinessServiceException;

	List<CourseDTO> getTotalCourseCount(CourseDTO courseDTO) throws BusinessServiceException;


}
