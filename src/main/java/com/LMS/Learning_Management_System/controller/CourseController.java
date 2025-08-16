package com.LMS.Learning_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.Learning_Management_System.DTO.CourseFacultyList;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService cservice;
	
	@PostMapping("/addcourse")
	//handle already present course
	public Course addCourse(@RequestBody Course c) {
		return cservice.addCourse(c);
	}
	
	@GetMapping("/courses")
	public List<CourseFacultyList> getAllCourses(){
		return cservice.getAllCourses();
	}
	
	@GetMapping("/course/{c_id}")
	//handle course not found
	public CourseFacultyList getCourseById(@PathVariable("c_id") int cId) {
		return cservice.getInstructors(cId);
	}
	
	@GetMapping("/coursefacultylist/{c_id}")
	//handle course not found
		public CourseFacultyList getCourseInstructors(@PathVariable ("c_id") int cId){
			return cservice.getInstructors(cId);
		}
	
	@PutMapping("/course/{c_id}/addInstructor/{f_id}")
	//handle faculty and course not found
	public void addNewCourseInstructor(@PathVariable ("c_id") int cid,@PathVariable ("f_id") String fId) {
		cservice.addNewCourseInst(fId, cid);
	}
	
	@DeleteMapping("/deleteCourse/{cid}")
	//handle course not found
	public void deleteCourse(@PathVariable ("cid") int cid) {
		cservice.deletecourse(cid);
	}

}
