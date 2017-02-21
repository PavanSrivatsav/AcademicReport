package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Student;

public interface StudentDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<Student> getAllStudents() throws DataServiceException;

}
