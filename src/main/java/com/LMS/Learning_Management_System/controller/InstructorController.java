package com.LMS.Learning_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.Learning_Management_System.DTO.FacultyCourseList;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.entities.Instructor;
import com.LMS.Learning_Management_System.service.InstructorService;

@RestController
public class InstructorController {
	
	@Autowired
	private InstructorService inservice;
	
	@PostMapping("/addinstructor")
	public Instructor addInstructor(@RequestBody Instructor ins) {
		return inservice.addInstructor(ins);
	}
	
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors(){
		return inservice.getAllInstructors();
	}
	
	@GetMapping("/instructor/{fid}")
	public Instructor getInstructorById(@PathVariable("fid") String Fid) {
		return inservice.getInsById(Fid);
	}
	
	@GetMapping("/instrcutorcourselist/{fid}")
	public FacultyCourseList getInstructorCourses(@PathVariable("fid") String Fid){
		return inservice.getFacultyCourses(Fid);
	}
	
	@PutMapping("/instructor{f_id}/addCourse{c_id}")
	public void addNewCourse(@PathVariable ("f_id") String fId,@PathVariable ("c_id") int cId) {
		inservice.addNewCourseForInst(fId, cId);
	}
}
