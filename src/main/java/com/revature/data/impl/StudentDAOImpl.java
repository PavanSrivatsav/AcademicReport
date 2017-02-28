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
	@Override
	public List<Student> getIndividualStudentByCourses(Integer collegeId,Integer departmentId,Integer studentId) throws DataServiceException {
		List<Student> individualStudentByCourses = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,`students`.`PHONE`,`students`.`BATCH`,courses.`NAME` as 'courses name',courses.`DESCRIPTION` as 'description'  FROM students JOIN student_courses ON students.`ID`=student_courses.`STUDENT_ID` JOIN seed_departments ON students.`DEPARTMENT_ID`=seed_departments.`ID` JOIN courses ON courses.`ID`=student_courses.`COURSE_ID` WHERE students.`COLLEGE_ID`=" +collegeId+ " AND students.`DEPARTMENT_ID`=" + departmentId+ " AND students.`ID`=" +studentId+" " );
			individualStudentByCourses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Individual Student By Courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return individualStudentByCourses;
	}

	@Override
	public List<Student> getIndividualStudentByProjects(Integer collegeId,Integer departmentId,Integer studentId) throws DataServiceException {
		List<Student> individualStudentByProjects = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,`students`.`PHONE`,`students`.`BATCH`, projects.`NAME` as 'project name',projects.`DESCRIPTION`'description' FROM students JOIN seed_departments ON students.`DEPARTMENT_ID`=seed_departments.`ID` JOIN student_projects ON students.`ID`=student_projects.`STUDENT_ID` JOIN projects ON projects.`ID`=student_projects.`PROJECT_ID`  WHERE students.`COLLEGE_ID`=" +collegeId+ " AND students.`DEPARTMENT_ID`=" + departmentId+ " AND students.`ID`=" +studentId+" " );
			individualStudentByProjects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Individual Student By Projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return individualStudentByProjects;
	}

}
