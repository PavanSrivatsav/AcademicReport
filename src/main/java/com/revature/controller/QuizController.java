package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.QuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Quiz;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

	private static Logger logger = Logger.getLogger(QuizController.class);

	@Autowired
	private QuizService quizService;

	@GetMapping("list/all")
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

	@GetMapping("list/id/{id}")
	public List<Quiz> getQuizByIdController(@PathVariable("id") Integer id) {
		List<Quiz> quizById = null;
		try {
			logger.info("Getting the Quiz by id data...");
			quizById = quizService.getQuizById(id);
			logger.info("Quiz by id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return quizById;
	}

	@GetMapping("list/name/{name}")
	public List<Quiz> getQuizByNameController(@PathVariable("name") String name) {
		List<Quiz> quizByName = null;
		try {
			logger.info("Getting the Quiz by name data...");
			quizByName = quizService.getQuizByName(name);
			logger.info("Quiz by name data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return quizByName;
	}

}
