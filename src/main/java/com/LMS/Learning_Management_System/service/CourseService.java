package com.LMS.Learning_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Learning_Management_System.DAO.CourseRepo;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.entities.Instructor;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepo crepo;
	
	//add course
	public Course addCourse(Course c) {
		return crepo.save(c);
	}
	
	//get a course detail with id;
	public Course getCourseById(int c_id) {
	Optional<Course> op= crepo.findById(c_id);
	if(!op.isPresent()) {
//		error
	}
	Course c= op.get();
	return c;
	}
	
	//get all course with details
	public List<Course> getAllCourses(){
		List<Course> allcourses = (List<Course>) crepo.findAll();
		return allcourses;
	}
	
	//get the course handling faculty list
	public List<Instructor> getInstructors(int c_id){
		Course c = getCourseById(c_id);
		return c.getInstructors();
	}
}
