package com.nilesh.jpa.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nilesh.jpa.demo1.Repository.CourseRepository;
import com.nilesh.jpa.demo1.entity.Course;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteById(10002);
		repository.save(new Course("Microservices in 20 steps"));
		logger.info("ALL Courses -> {}",repository.findAll());
		
	}

}
