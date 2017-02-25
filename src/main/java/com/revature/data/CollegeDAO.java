package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.College;

public interface CollegeDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<College> getAllColleges() throws DataServiceException;

	public List<College> getCollegeById(Integer collegeId) throws DataServiceException;

	public List<College> getCollegeByName(String collegeName) throws DataServiceException;

}
