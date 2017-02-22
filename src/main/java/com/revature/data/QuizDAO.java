package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Quiz;

public interface QuizDAO {

	/**
	 * @return
	 * @throws DataServiceException
	 */

	public List<Quiz> getAllQuizzes() throws DataServiceException;

}
