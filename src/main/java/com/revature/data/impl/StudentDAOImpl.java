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
		return null;
	}

	@Override
	public List<Student> getStudentByEmailId(String sudentName) throws DataServiceException {
		return null;
	}

	/*
	 * @Override public List<StudentCourseDTO>
	 * getIndividualStudentByCourses(StudentCourseDTO studentCourseDTOInteger
	 * collegeId,Integer departmentId,Integer studentId) throws
	 * DataServiceException { List<StudentCourseDTO> individualStudentByCourses
	 * = null; // List<Student> student=null; // Student student; try {
	 * logger.info("In dao layer..."); StringBuilder sb = new
	 * StringBuilder("SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,`students`.`PHONE`,`students`.`BATCH`,courses.`NAME` as 'courses name',courses.`DESCRIPTION` as 'description'  FROM students JOIN student_courses ON students.`ID`=student_courses.`STUDENT_ID` JOIN seed_departments ON students.`DEPARTMENT_ID`=seed_departments.`ID` JOIN courses ON courses.`ID`=student_courses.`COURSE_ID` WHERE students.`COLLEGE_ID`="
	 * +studentCourseDTO.getCollegeId()+ " AND students.`DEPARTMENT_ID`=" +
	 * studentCourseDTO.getDepartmentId()+ " AND students.`ID`="
	 * +studentCourseDTO.getStudentId()+" " ); // student = (Student)
	 * dataRetriver.retrieveBySQL(sb.toString(), StudentCourseDTO.class); //
	 * studentCourseDTO.setStudentName(student.getName());
	 * individualStudentByCourses = dataRetriver.retrieveBySQL(sb.toString(),
	 * StudentCourseDTO.class);
	 * logger.info("Individual Student By Courses data retrieval success.."); }
	 * catch (DataAccessException e) { logger.error(e.getMessage(), e); throw
	 * new
	 * DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"),
	 * e); } return individualStudentByCourses; }
	 */
	@Override
	public List<Student> getIndividualStudentByCourses(Integer collegeId, Integer departmentId, Integer studentId)
			throws DataServiceException {
		List<Student> individualStudentByCourses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,`students`.`PHONE`,`students`.`BATCH`,courses.`NAME` as 'courses name',courses.`DESCRIPTION` as 'description'  FROM students JOIN student_courses ON students.`ID`=student_courses.`STUDENT_ID` AND `students`.`IS_ACTIVE`=TRUE JOIN seed_departments ON students.`DEPARTMENT_ID`=seed_departments.`ID` AND `seed_departments`.`IS_ACTIVE`=TRUE JOIN courses ON courses.`ID`=student_courses.`COURSE_ID` AND `courses`.`IS_ACTIVE`=TRUE WHERE students.`COLLEGE_ID`="
							+ collegeId + " AND students.`DEPARTMENT_ID`=" + departmentId + " AND students.`ID`="
							+ studentId + " ");
			individualStudentByCourses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Individual Student By Courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return individualStudentByCourses;
	}

	@Override
	public List<Student> getIndividualStudentByProjects(Integer collegeId, Integer departmentId, Integer studentId)
			throws DataServiceException {
		List<Student> individualStudentByProjects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,`students`.`PHONE`,`students`.`BATCH`, projects.`NAME` as 'project name',projects.`DESCRIPTION`'description' FROM students JOIN seed_departments ON students.`DEPARTMENT_ID`=seed_departments.`ID` AND `students`.`IS_ACTIVE`=TRUE AND `seed_departments`.`IS_ACTIVE`=TRUE  JOIN student_projects ON students.`ID`=student_projects.`STUDENT_ID` JOIN projects ON projects.`ID`=student_projects.`PROJECT_ID`  AND projects.`IS_ACTIVE`=TRUE WHERE students.`COLLEGE_ID`="
							+ collegeId + " AND students.`DEPARTMENT_ID`=" + departmentId + " AND students.`ID`="
							+ studentId + " ");
			individualStudentByProjects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Individual Student By Projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return individualStudentByProjects;
	}

	@Override
	public List<Student> getOverAllStudentByCurrentCourses(Integer collegeId, Integer departmentId)
			throws DataServiceException {
		List<Student> overAllStudentByCurrentCourses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,courses.`NAME` as 'Current courses name' FROM students JOIN student_courses ON students.`ID`=student_courses.`STUDENT_ID` AND `students`.`IS_ACTIVE`=TRUE JOIN `seed_departments` ON `students`.`DEPARTMENT_ID`=`seed_departments`.`ID` AND `seed_departments`.`IS_ACTIVE`=TRUE JOIN courses ON courses.`ID`=student_courses.`COURSE_ID` AND `courses`.`IS_ACTIVE`=TRUE WHERE students.`COLLEGE_ID`="
							+ collegeId + " AND students.`DEPARTMENT_ID`=" + departmentId
							+ " AND student_courses.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='IN PROGRESS')");
			overAllStudentByCurrentCourses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Over All Student By Current Courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return overAllStudentByCurrentCourses;
	}

	@Override
	public List<Student> getOverAllStudentByCompletedCourses(Integer collegeId, Integer departmentId)
			throws DataServiceException {
		List<Student> overAllStudentByCompletedCourses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,courses.`NAME` as 'Completed courses name' FROM students JOIN student_courses ON students.`ID`=student_courses.`STUDENT_ID` AND `students`.`IS_ACTIVE`=TRUE JOIN `seed_departments` ON `students`.`DEPARTMENT_ID`=`seed_departments`.`ID` AND `seed_departments`.`IS_ACTIVE`=TRUE JOIN courses ON courses.`ID`=student_courses.`COURSE_ID` AND `courses`.`IS_ACTIVE`=TRUE WHERE students.`COLLEGE_ID`="
							+ collegeId + " AND students.`DEPARTMENT_ID`=" + departmentId
							+ " AND student_courses.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='COMPLETED') ");
			overAllStudentByCompletedCourses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Over All Student By Completed Courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return overAllStudentByCompletedCourses;
	}

	@Override
	public List<Student> getOverAllStudentByCurrentProjects(Integer collegeId, Integer departmentId)
			throws DataServiceException {
		List<Student> overAllStudentByCurrentProjects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,projects.`NAME` as 'Current projects name' FROM students JOIN `student_projects` ON students.`ID`=student_projects.`STUDENT_ID` AND `students`.`IS_ACTIVE`=TRUE JOIN `seed_departments` ON `students`.`DEPARTMENT_ID`=`seed_departments`.`ID` AND `seed_departments`.`IS_ACTIVE`=TRUE JOIN `projects` ON projects.`ID`=`student_projects`.`PROJECT_ID` AND projects.`IS_ACTIVE`=TRUE WHERE students.`COLLEGE_ID`="
							+ collegeId + " AND students.`DEPARTMENT_ID`=" + departmentId
							+ " AND student_projects.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='IN PROGRESS')");
			overAllStudentByCurrentProjects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Over All Student By Current Projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return overAllStudentByCurrentProjects;
	}

	@Override
	public List<Student> getOverAllStudentByCompletedProjects(Integer collegeId, Integer departmentId)
			throws DataServiceException {
		List<Student> overAllStudentByCompletedProjects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,projects.`NAME` as 'Completed projects name' FROM students JOIN `student_projects` ON students.`ID`=student_projects.`STUDENT_ID` AND `students`.`IS_ACTIVE`=TRUE JOIN `seed_departments` ON `students`.`DEPARTMENT_ID`=`seed_departments`.`ID` AND `seed_departments`.`IS_ACTIVE`=TRUE JOIN `projects` ON projects.`ID`=`student_projects`.`PROJECT_ID` AND projects.`IS_ACTIVE`=TRUE WHERE students.`COLLEGE_ID`="
							+ collegeId + " AND students.`DEPARTMENT_ID`=" + departmentId
							+ " AND student_projects.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='COMPLETED')");
			overAllStudentByCompletedProjects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Over All Student By Completed Projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return overAllStudentByCompletedProjects;
	}

}
