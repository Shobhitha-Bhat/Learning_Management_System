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

import com.LMS.Learning_Management_System.DTO.StudentEnrollments;
import com.LMS.Learning_Management_System.DTO.UpdateStudent;
import com.LMS.Learning_Management_System.entities.Student;
import com.LMS.Learning_Management_System.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService stservice;
	
	@PostMapping("/addStudent")
	//handle same student entry
	public Student addStudent(@RequestBody Student st) {
		return stservice.addStudent(st);
	}
	
	@GetMapping("/students")
	public List<StudentEnrollments> allstudents(){
		return stservice.getAllStudents();
	}
	
	@GetMapping("/student/{usn}")
	public StudentEnrollments getStudentById(@PathVariable("usn") String usn) {
		return stservice.getStudentDetailsById(usn);
	}
	
	@PutMapping("/updateStudent/{usn}")
	public void updateStudent(@PathVariable ("usn") String usn,@RequestBody UpdateStudent st) {
		//avoid using Student request body cz u have to pass enrollments and enrollments again has many field..
		stservice.updateStudentDetails(usn,st);
	}
	
	@DeleteMapping("/deleteStudent/{usn}")
	public void deleteStudent(@PathVariable ("usn") String usn) {
		stservice.deletestudent(usn);
	}
	
	

}
