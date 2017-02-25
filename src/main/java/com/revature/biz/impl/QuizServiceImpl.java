package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.QuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.QuizDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Quiz;

@Service
public class QuizServiceImpl implements QuizService {
	private static Logger logger = Logger.getLogger(QuizServiceImpl.class);

	@Autowired
	private QuizDAO quizDAO;

	@Override
	public List<Quiz> getAllQuizzes() throws BusinessServiceException {
		List<Quiz> quizzes = null;
		try {
			quizzes = quizDAO.getAllQuizzes();
			logger.info("Quizzes retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return quizzes;
	}

	@Override
	public List<Quiz> getQuizById(Integer quizId) throws BusinessServiceException {
		List<Quiz> quizById = null;
		try {
			quizById = quizDAO.getQuizById(quizId);
			logger.info("Quiz by id retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return quizById;
	}

	@Override
	public List<Quiz> getQuizByName(String quizName) throws BusinessServiceException {
		List<Quiz> quizByName = null;
		try {
			quizByName = quizDAO.getQuizByName(quizName);
			logger.info("Quiz by name retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return quizByName;
	}
}
