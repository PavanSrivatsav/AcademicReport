package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.DashboardDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentCourse;
@Repository

public class DashboardDAOImpl implements DashboardDAO{
	private static Logger logger = Logger.getLogger(DashboardDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<StudentCourse> getActiveCourses(Integer collegeId,Integer departmentId) throws DataServiceException {
		List<StudentCourse> activeCourses = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT students.`NAME` FROM `students` JOIN `student_courses` ON  `student_courses`.`STUDENT_ID`=`students`.`ID` WHERE `student_courses`.`STATUS_ID`=(SELECT id FROM seed_status WHERE NAME='COMPLETED') AND `students`.`DEPARTMENT_ID`=" + departmentId+ " AND `students`.`COLLEGE_ID`=" + collegeId + " GROUP BY `STUDENT_ID` ORDER BY COUNT(`COURSE_ID`) DESC LIMIT 5");
			activeCourses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Active courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return activeCourses;
	}

}
