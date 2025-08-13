package com.LMS.Learning_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Learning_Management_System.DAO.StudentRepo;
import com.LMS.Learning_Management_System.entities.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepo strepo;
	
	//add student
	public Student addStudent(Student st) {
		return strepo.save(st);
	}
	
	//get student by id
	public Student getStudentById(String usn) {
		Optional<Student> op=strepo.findById(usn);
		if(!op.isPresent()) {
//			error
		}
		Student st=op.get();
		return st;
	}
	
	//get all students
	public List<Student> getAllStudents(){
		List<Student> allst = (List<Student>) strepo.findAll();
		return allst;
	}
	
	
	
	
}
