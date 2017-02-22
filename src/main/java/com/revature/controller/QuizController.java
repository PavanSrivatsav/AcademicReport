package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.QuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Quiz;

@RestController

public class QuizController {

	private static Logger logger = Logger.getLogger(QuizController.class);

	@Autowired
	private QuizService quizService;

	@RequestMapping("/quizzes")
	public List<Quiz> getQuizController() {
		List<Quiz> quizzes = null;
		try {
			logger.info("Getting the Quizzes data...");
			quizzes = quizService.getAllQuizzes();
			logger.info("Quizzes data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return quizzes;
	}
}
