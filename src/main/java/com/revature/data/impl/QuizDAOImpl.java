package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.QuizDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Quiz;

@Repository
public class QuizDAOImpl implements QuizDAO {

	private static Logger logger = Logger.getLogger(QuizDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<Quiz> getAllQuizzes() throws DataServiceException {
		List<Quiz> quizzes = null;
		try {
			StringBuilder sb = new StringBuilder("select * from quizzes q where q.IS_ACTIVE=true");
			quizzes = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Quizzes data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return quizzes;
	}

	@Override
	public List<Quiz> getQuizById(Integer id) throws DataServiceException {
		List<Quiz> quizById = null;
		try {
			StringBuilder sb = new StringBuilder("select * from quizzes q where ID=" + id + " and q.IS_ACTIVE=true");
			quizById = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Quiz by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return quizById;
	}

	@Override
	public List<Quiz> getQuizByName(String name) throws DataServiceException {
		List<Quiz> quizByName = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select * from quizzes q where NAME='" + name + "' and q.IS_ACTIVE=true");
			quizByName = dataRetriver.retrieveBySQLAsJSONInDAO(sb.toString());
			logger.info("Quiz by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return quizByName;
	}
}
