package com.demo.spring.Application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.spring.Application.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	// jpql
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
	  @Query(value = "select * from course tu where tu.course_name= ?1 or  tu.author_name= ?1",
	  nativeQuery = true) Course findByName(String name);
	  
		/*
		 * @Query(value = "select tu from course tu where tu.cours_id= :id ") Course
		 * findByPId(@Param("id") Integer id);
		 */
	 
}
