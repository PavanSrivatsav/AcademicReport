package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.UserDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.User;
import com.revature.model.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Autowired
	private DataModifier dataModifier;

	public DataModifier getDataModifier() {
		return dataModifier;
	}

	public void setDataModifier(DataModifier dataModifier) {
		this.dataModifier = dataModifier;
	}

	@Override
	public List<UserDTO> getAllUsers() throws DataServiceException {
		List<UserDTO> users = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select u.ID id, u.NAME name, u.EMAIL_ID emailId, u.PASSWORD password, u.DEPARTMENT_ID departmentId, u.COLLEGE_ID collegeId, u.ROLE_ID roleId, u.PHONE_NUMBER phone from users u where u.IS_ACTIVE=true");
			users = dataRetriver.retrieveBySQLAsJSON(sb.toString(), UserDTO.class);
			logger.info("Users data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return users;
	}

	@Override
	public <E> UserDTO getUserById(User user) throws DataServiceException {
		UserDTO userById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select u.ID id, u.NAME name, u.EMAIL_ID emailId, u.PASSWORD password, u.DEPARTMENT_ID departmentId, u.COLLEGE_ID collegeId, u.ROLE_ID roleId, u.PHONE_NUMBER phone from users u where u.ID='"
							+ user.getId() + "' and u.IS_ACTIVE=true");
			userById = (UserDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(), UserDTO.class);
			logger.info("User by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userById;
	}

	@Override
	public <E> UserDTO getUserByEmailId(User user) throws DataServiceException {
		UserDTO userByEmailId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select u.ID id, u.NAME name, u.EMAIL_ID emailId, u.PASSWORD password, u.DEPARTMENT_ID departmentId, u.COLLEGE_ID collegeId, u.ROLE_ID roleId, u.PHONE_NUMBER phone from users u where u.EMAIL_ID='"
							+ user.getEmailId() + "' and u.IS_ACTIVE=true");
			userByEmailId = (UserDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(), UserDTO.class);
			logger.info("User by email id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userByEmailId;
	}

	@Override
	public List<UserDTO> getUsersByCollegeId(User user) throws DataServiceException {
		List<UserDTO> userByCollegeId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select u.ID id, u.NAME name, u.EMAIL_ID emailId, u.PASSWORD password, u.DEPARTMENT_ID departmentId, u.COLLEGE_ID collegeId, u.ROLE_ID roleId, u.PHONE_NUMBER phone from users u where u.COLLEGE_ID='"
							+ user.getCollege().getId() + "' and u.IS_ACTIVE=true");
			userByCollegeId = dataRetriver.retrieveBySQLAsJSON(sb.toString(), UserDTO.class);
			logger.info("Users by college id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userByCollegeId;
	}

	@Override
	public List<UserDTO> getUsersByDepartmentId(User user) throws DataServiceException {
		List<UserDTO> userByDepartmentId = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select u.ID id, u.NAME name, u.EMAIL_ID emailId, u.PASSWORD password, u.DEPARTMENT_ID departmentId, u.COLLEGE_ID collegeId, u.ROLE_ID roleId, u.PHONE_NUMBER phone from users u where u.DEPARTMENT_ID='"
							+ user.getDepartment().getId() + "' and u.IS_ACTIVE=true");
			userByDepartmentId = dataRetriver.retrieveBySQLAsJSON(sb.toString(), UserDTO.class);
			logger.info("Users by department id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userByDepartmentId;
	}

	@Override
	public <E> UserDTO getUserByLogin(User user) throws DataServiceException {
		UserDTO userDTOObj = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select u.password from users u where u.EMAIL_ID='" + user.getEmailId() + "' and u.IS_ACTIVE=true");
			userDTOObj = (UserDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(), UserDTO.class);
			if (userDTOObj == null)
				logger.info("User not exists");
			else {
				String dbPassword = userDTOObj.getPassword();
				logger.info("Pass-db     " + dbPassword);
				if (DataUtils.checkPassword(user.getPassword(), dbPassword)) {
					logger.info("User login success...");
					StringBuilder sb1 = new StringBuilder(
							"SELECT id id,username name,emailId emailId,departmentId departmentId,collegeId collegeId,roleId roleId,phone phone,roleName roleName,collegeName collegeName,departmentName departmentName FROM vw_user_details WHERE emailId='"
									+ user.getEmailId() + "'");
					userDTOObj = (UserDTO) dataRetriver.retrieveBySQLAsObject(sb1.toString(), UserDTO.class);
				} else
					logger.info("User login failure...");
				logger.info("Users data retrieval success..");
			}
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userDTOObj;
	}

	@Override
	public String insertUserPassword(User user) throws DataServiceException {
		String hashedPassword = null;
		int rows = 0;
		String msg = null;
		try {
			hashedPassword = DataUtils.encryptPassword(user.getPassword());
			StringBuilder sb = new StringBuilder("update users u set u.password='" + hashedPassword
					+ "' where u.EMAIL_ID='" + user.getEmailId() + "' and u.IS_ACTIVE=true");
			rows = dataModifier.retrieveBySQL(sb.toString());
			if (rows == 0)
				msg = "Password not inserted...";
			else
				msg = "Password inserted...";
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_modifier_fail"), e);
		}
		logger.info(msg);
		return msg;
	}

	@Override
	public String updateUserPassword(User user, String newPassword) throws DataServiceException {
		String msg = null;
		UserDTO userDTOObj = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select u.password from users u where u.EMAIL_ID='" + user.getEmailId() + "' and u.IS_ACTIVE=true");
			userDTOObj = (UserDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(), UserDTO.class);
			String dbPassword = userDTOObj.getPassword();
			logger.info("Pass-db     " + dbPassword);
			if (DataUtils.checkPassword(user.getPassword(), dbPassword)) {
				logger.info("User login success...");
				String hashedPassword = DataUtils.encryptPassword(newPassword);
				StringBuilder sb1 = new StringBuilder(
						"update users u set u.password='" + hashedPassword + "' where u.EMAIL_ID='" + user.getEmailId()
								+ "' and u.PASSWORD='" + dbPassword + "' and u.IS_ACTIVE=true");
				int rows = dataModifier.retrieveBySQL(sb1.toString());
				logger.info("no. of rows updated... " + rows);
				if (rows == 0)
					msg = "Password not updated...";
				else
					msg = "Password udated...";
			} else
				logger.info("User login failure...");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_modifier_fail"), e);
		}
		return msg;
	}

}
