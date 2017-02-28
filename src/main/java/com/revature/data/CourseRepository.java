package com.revature.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	@Query(name = "select * from courses c where c.NAME=?1 and c.IS_ACTIVE=true", nativeQuery = true)
	public List<Course> findByName(String name);

	public List<Course> findByCategory(Integer id);

}
