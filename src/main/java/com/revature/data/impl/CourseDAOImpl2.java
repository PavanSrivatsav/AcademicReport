package com.revature.data.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.revature.data.CourseDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Course;

@Repository
@Primary
public class CourseDAOImpl2 implements CourseDAO {

	private static Logger logger = Logger.getLogger(CourseDAOImpl2.class);
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Course> getAllCourses() throws DataServiceException {
		System.out.println("Entity Manager:" + entityManager);

		try {
			List resultList = entityManager
					.createNativeQuery("select * from courses c where c.IS_ACTIVE=true", Course.class).getResultList();
			logger.info("Courses data retrieval success..");
			return resultList;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
	}

	@Override
	public List<Course> getCourseById(Integer id) throws DataServiceException {
		List<Course> coursesById = null;
		try {
			coursesById = entityManager.createNativeQuery(
					"select * from courses c where c.ID=" + id + " and c.IS_ACTIVE=true", Course.class).getResultList();

			logger.info("Courses by id data retrieval success..");

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return coursesById;
	}

	@Override
	public List<Course> getCourseByName(String courseName) throws DataServiceException {
		List<Course> coursesByName = null;
		try {
			coursesByName = entityManager
					.createNativeQuery("select * from courses c where c.NAME='" + courseName + "' and c.IS_ACTIVE=true",
							Course.class)
					.getResultList();

			logger.info("Courses by course name data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return coursesByName;
	}

	@Override
	public List<Course> getCourseByCategoryId(Integer categoryId) throws DataServiceException {
		List<Course> coursesByCategoryId = null;
		try {
			coursesByCategoryId = entityManager.createNativeQuery(
					"select * from courses c where c.CATEGORY_ID=" + categoryId + " and c.IS_ACTIVE=true", Course.class)
					.getResultList();

			logger.info("Courses by category id data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return coursesByCategoryId;
	}
}
