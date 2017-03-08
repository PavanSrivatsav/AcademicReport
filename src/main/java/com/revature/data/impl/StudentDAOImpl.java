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
import com.revature.model.dto.StudentCourseDTO;
import com.revature.model.dto.StudentDTO;
import com.revature.model.dto.StudentProjectDTO;

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
	public List<StudentDTO> getAllStudents() throws DataServiceException {
		List<StudentDTO> students = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select id id, name name, email_id emailId from students s where s.IS_ACTIVE=true");
			students = dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentDTO.class);
			logger.info("Students data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return students;
	}

	@Override
	public <E> StudentDTO getStudentDetailsById(Student student) throws DataServiceException {
		StudentDTO individualStudentDetails = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT id id,student_name name,college_id collegeId,department_id departmentId,department_name departmentName,email_id emailId,phone phone,batch batch,area_of_interest areaOfInterest FROM vw_student_detail WHERE ID="
							+ student.getId());
			individualStudentDetails = (StudentDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(), StudentDTO.class);
			logger.info("Individual Student By Courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return individualStudentDetails;
	}

	@Override
	public <E> StudentDTO getStudentByEmailId(Student sudent) throws DataServiceException {
		return null;
	}

	@Override
	public List<StudentCourseDTO> getStudentCoursesByStudentId(Student student) throws DataServiceException {
		List<StudentCourseDTO> individualStudentByCourses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT student_id studentId,course_id courseId,course_name courseName,description description FROM vw_student_course WHERE student_id="
							+ student.getId());
			individualStudentByCourses = dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentCourseDTO.class);
			logger.info("Individual Student By Courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return individualStudentByCourses;
	}

	@Override
	public List<StudentProjectDTO> getStudentProjectsByStudentId(Student student) throws DataServiceException {
		List<StudentProjectDTO> individualStudentByProjects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT student_id studentId,project_id projectId,project_name projectName,description description FROM vw_student_project WHERE student_id="
							+ student.getId());
			individualStudentByProjects = dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentProjectDTO.class);
			logger.info("Individual Student By Projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return individualStudentByProjects;
	}

	/*
	 * @Override public List<StudentDTO>
	 * getOverAllStudentByCurrentCourses(Student student) throws
	 * DataServiceException { List<StudentDTO> overAllStudentByCurrentCourses =
	 * null; try { StringBuilder sb = new StringBuilder(
	 * "SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,courses.`NAME` as 'Current courses name' FROM students JOIN student_courses ON students.`ID`=student_courses.`STUDENT_ID` AND `students`.`IS_ACTIVE`=TRUE JOIN `seed_departments` ON `students`.`DEPARTMENT_ID`=`seed_departments`.`ID` AND `seed_departments`.`IS_ACTIVE`=TRUE JOIN courses ON courses.`ID`=student_courses.`COURSE_ID` AND `courses`.`IS_ACTIVE`=TRUE WHERE students.`COLLEGE_ID`="
	 * + student.getCollege().getId() + " AND students.`DEPARTMENT_ID`=" +
	 * student.getDepartment().getId() +
	 * " AND student_courses.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='IN PROGRESS')"
	 * ); overAllStudentByCurrentCourses =
	 * dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentDTO.class);
	 * logger.
	 * info("Over All Student By Current Courses data retrieval success.."); }
	 * catch (DataAccessException e) { logger.error(e.getMessage(), e); throw
	 * new
	 * DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"),
	 * e); } return overAllStudentByCurrentCourses; }
	 * 
	 * @Override public List<StudentDTO>
	 * getOverAllStudentByCompletedCourses(Student student) throws
	 * DataServiceException { List<StudentDTO> overAllStudentByCompletedCourses
	 * = null; try { StringBuilder sb = new StringBuilder(
	 * "SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,courses.`NAME` as 'Completed courses name' FROM students JOIN student_courses ON students.`ID`=student_courses.`STUDENT_ID` AND `students`.`IS_ACTIVE`=TRUE JOIN `seed_departments` ON `students`.`DEPARTMENT_ID`=`seed_departments`.`ID` AND `seed_departments`.`IS_ACTIVE`=TRUE JOIN courses ON courses.`ID`=student_courses.`COURSE_ID` AND `courses`.`IS_ACTIVE`=TRUE WHERE students.`COLLEGE_ID`="
	 * + student.getCollege().getId() + " AND students.`DEPARTMENT_ID`=" +
	 * student.getDepartment().getId() +
	 * " AND student_courses.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='COMPLETED') "
	 * ); overAllStudentByCompletedCourses =
	 * dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentDTO.class);
	 * logger.
	 * info("Over All Student By Completed Courses data retrieval success.."); }
	 * catch (DataAccessException e) { logger.error(e.getMessage(), e); throw
	 * new
	 * DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"),
	 * e); } return overAllStudentByCompletedCourses; }
	 * 
	 * @Override public List<StudentDTO>
	 * getOverAllStudentByCurrentProjects(Student student) throws
	 * DataServiceException { List<StudentDTO> overAllStudentByCurrentProjects =
	 * null; try { StringBuilder sb = new StringBuilder(
	 * "SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,projects.`NAME` as 'Current projects name' FROM students JOIN `student_projects` ON students.`ID`=student_projects.`STUDENT_ID` AND `students`.`IS_ACTIVE`=TRUE JOIN `seed_departments` ON `students`.`DEPARTMENT_ID`=`seed_departments`.`ID` AND `seed_departments`.`IS_ACTIVE`=TRUE JOIN `projects` ON projects.`ID`=`student_projects`.`PROJECT_ID` AND projects.`IS_ACTIVE`=TRUE WHERE students.`COLLEGE_ID`="
	 * + student.getCollege().getId() + " AND students.`DEPARTMENT_ID`=" +
	 * student.getDepartment().getId() +
	 * " AND student_projects.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='IN PROGRESS')"
	 * ); overAllStudentByCurrentProjects =
	 * dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentDTO.class);
	 * logger.
	 * info("Over All Student By Current Projects data retrieval success.."); }
	 * catch (DataAccessException e) { logger.error(e.getMessage(), e); throw
	 * new
	 * DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"),
	 * e); } return overAllStudentByCurrentProjects; }
	 * 
	 * @Override public List<StudentDTO>
	 * getOverAllStudentByCompletedProjects(Student student) throws
	 * DataServiceException { List<StudentDTO> overAllStudentByCompletedProjects
	 * = null; try { StringBuilder sb = new StringBuilder(
	 * "SELECT students.`NAME`,seed_departments.`NAME` as 'department name',`students`.`EMAIL_ID`,projects.`NAME` as 'Completed projects name' FROM students JOIN `student_projects` ON students.`ID`=student_projects.`STUDENT_ID` AND `students`.`IS_ACTIVE`=TRUE JOIN `seed_departments` ON `students`.`DEPARTMENT_ID`=`seed_departments`.`ID` AND `seed_departments`.`IS_ACTIVE`=TRUE JOIN `projects` ON projects.`ID`=`student_projects`.`PROJECT_ID` AND projects.`IS_ACTIVE`=TRUE WHERE students.`COLLEGE_ID`="
	 * + student.getCollege().getId() + " AND students.`DEPARTMENT_ID`=" +
	 * student.getDepartment().getId() +
	 * " AND student_projects.`STATUS_ID`=(SELECT id FROM `seed_status` WHERE `seed_status`.`NAME`='COMPLETED')"
	 * ); overAllStudentByCompletedProjects =
	 * dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentDTO.class);
	 * logger.
	 * info("Over All Student By Completed Projects data retrieval success..");
	 * } catch (DataAccessException e) { logger.error(e.getMessage(), e); throw
	 * new
	 * DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"),
	 * e); } return overAllStudentByCompletedProjects; }
	 */
	@Override
	public List<StudentDTO> getAllStudentByCollege(Student student) throws DataServiceException {
		List<StudentDTO> overAllStudentByCompletedProjects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT id id,department_id departmentId,college_id collegeId,current_courses_name currentCourse,completed_courses_name completedCourse,current_projects_name currentProject,completed_projects_name completedProject FROM vw_overall_student_list WHERE college_id="
							+ student.getCollege().getId() + " AND department_id=" + student.getDepartment().getId()
							+ " ORDER BY id");
			overAllStudentByCompletedProjects = dataRetriver.retrieveBySQLAsJSON(sb.toString(), StudentDTO.class);
			logger.info("Over All Student By Completed Projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return overAllStudentByCompletedProjects;
	}

}
