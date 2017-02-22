package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Quiz;

public interface QuizService {
	/**
	 * @return
	 * @throws BusinessServiceException
	 */
	List<Quiz> getAllQuizzes() throws BusinessServiceException;
}
