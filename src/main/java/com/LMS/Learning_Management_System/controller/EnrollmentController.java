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

import com.LMS.Learning_Management_System.DTO.EnrollmentList;
import com.LMS.Learning_Management_System.DTO.EnrollmentRequest;
import com.LMS.Learning_Management_System.DTO.UpdateEnrollment;
import com.LMS.Learning_Management_System.entities.Enrollments;
import com.LMS.Learning_Management_System.service.EnrollmentService;

@RestController
public class EnrollmentController {
	
	@Autowired
	private EnrollmentService enservice;
	
	@GetMapping("/getenrollments/{c_id}")
	//handle empty course enrollments
	public EnrollmentList getAllEnrollments(@PathVariable ("c_id") int cId){
		return enservice.getAllStudentsInCourse(cId);
	}
	
	@PostMapping("/addenrollment/{usn}/{cid}")
	//handle course and student notfound
	public void addEnrollment(@PathVariable ("usn")String USN, @PathVariable ("cid") int cId) {
		enservice.addStudentCourse(USN, cId);
	}
	
	@PostMapping("/addenrollments")
	//handle student not found and course not found
	public void addManyEnrollments(@RequestBody EnrollmentRequest enreq ) {
		enservice.addStudentsandTheirCourses(enreq);
	}
	
	@PutMapping("/updateEnrollment")
	//handle invalid usn and cid
	public void updatEnrollment(@RequestBody UpdateEnrollment upen) {
		enservice.modifyStudentMarks(upen);
	}
	
	@DeleteMapping("/deleteEnrollment/{usn}/{c_id}")
	//handle course and student valid deletions
	public void deleteEnrollment(@PathVariable ("usn") String usn,@PathVariable ("c_id") int cId) {
		enservice.deleteEnrollment(usn, cId);
	}
}
