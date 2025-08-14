package com.LMS.Learning_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.Learning_Management_System.entities.Student;
import com.LMS.Learning_Management_System.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService stservice;
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student st) {
		return stservice.addStudent(st);
	}
	
	@GetMapping("/students")
	public List<Student> allstudents(){
		return stservice.getAllStudents();
	}
	
	@GetMapping("/student/{usn}")
	public Student getStudentById(@PathVariable("usn") String usn) {
		return stservice.getStudentById(usn);
	}
	
	

}
