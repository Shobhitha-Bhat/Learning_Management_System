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

import com.LMS.Learning_Management_System.DTO.EnrollmentRequest;
import com.LMS.Learning_Management_System.DTO.UpdateEnrollment;
import com.LMS.Learning_Management_System.entities.Enrollments;
import com.LMS.Learning_Management_System.service.EnrollmentService;

@RestController
public class EnrollmentController {
	
	@Autowired
	private EnrollmentService enservice;
	
	@GetMapping("/getenrollments/{c_id}")
	public List<Enrollments> getAllEnrollments(@PathVariable ("c_id") int cId){
		return enservice.getAllStudentsInCourse(cId);
	}
	
	@PostMapping("/addenrollment/{usn}/{cid}")
	public Enrollments addEnrollment(@PathVariable ("usn")String USN, @PathVariable ("cid") int cId) {
		return enservice.addStudentCourse(USN, cId);
	}
	
	@PostMapping("/addenrollments")
	public void addManyEnrollments(@RequestBody EnrollmentRequest enreq ) {
		enservice.addStudentsandTheirCourses(enreq);
	}
	
	@PutMapping("/updateEnrollment")
	public void updatEnrollment(@RequestBody UpdateEnrollment upen) {
		enservice.modifyStudentMarks(upen);
	}
	
	@DeleteMapping("/deleteEnrollment/{usn}/{c_id}")
	public void deleteEnrollment(@PathVariable ("usn") String usn,@PathVariable ("c_id") int cId) {
		enservice.deleteEnrollment(usn, cId);
	}
}
