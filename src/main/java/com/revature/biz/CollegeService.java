package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.College;

public interface CollegeService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<College> getAllColleges() throws BusinessServiceException;

	List<College> getCollegeById(Integer collegeId) throws BusinessServiceException;

	List<College> getCollegeByName(String collegeName) throws BusinessServiceException;
}
