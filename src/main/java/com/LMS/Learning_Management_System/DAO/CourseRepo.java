package com.LMS.Learning_Management_System.DAO;


import org.springframework.data.repository.CrudRepository;

import com.LMS.Learning_Management_System.entities.Course;

public interface CourseRepo extends CrudRepository<Course, Integer>{
	
}
