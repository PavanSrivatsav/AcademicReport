package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private static Logger logger = Logger.getLogger(StudentDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<Student> getAllStudents() throws DataServiceException {
		List<Student> students = null;
		try {
			StringBuilder sb = new StringBuilder("select * from students s where s.IS_ACTIVE=true");
			students = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Students data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return students;
	}

	@Override
	public List<Student> getStudentById(int studentId) throws DataServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentByEmailId(String sudentName) throws DataServiceException {
		// TODO Auto-generated method stub
		return null;
	}
}
