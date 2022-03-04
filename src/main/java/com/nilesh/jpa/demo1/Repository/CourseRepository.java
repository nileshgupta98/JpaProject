package com.nilesh.jpa.demo1.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nilesh.jpa.demo1.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public List<Course> findAll(){
		TypedQuery<Course> namedQuery = em.createNamedQuery("find_all_courses", Course.class);
		return namedQuery.getResultList();
	}
	
	public Course findById(long id) {
		return em.find(Course.class, id);
	}
	
	public Course save(Course course) {
		if(course.getId()==null) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
	}
	
	public void deleteById(long i) {
		Course course = findById(i);
		em.remove(course);
	}
}
