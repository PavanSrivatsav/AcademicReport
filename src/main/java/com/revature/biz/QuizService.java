package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Quiz;

public interface QuizService {

	List<Quiz> getAllQuizzes() throws BusinessServiceException;

	List<Quiz> getQuizById(int quizId) throws BusinessServiceException;

	List<Quiz> getQuizByName(String quizName) throws BusinessServiceException;
}
