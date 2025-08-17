package com.LMS.Learning_Management_System.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.LMS.Learning_Management_System.DTO.UpdateStudent;
import com.LMS.Learning_Management_System.entities.Student;
import com.LMS.Learning_Management_System.service.StudentService;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
	
	@Mock
	private StudentService sservice;
	@InjectMocks
	private StudentController scontroller;
	
	@Test
	public void test_addStudent() {
		Student s=new Student();
		scontroller.addStudent(s);
		verify(sservice,times(1)).addStudent(s);
	}
	
	@Test
	public void test_allstudents() {
		scontroller.allstudents();
		verify(sservice,times(1)).getAllStudents();
	}
	
	@Test
	public void test_getStudentById() {
		scontroller.getStudentById("abc");
		verify(sservice,times(1)).getStudentDetailsById("abc");
	}
	
	@Test
	public void test_updateStudent() {
		UpdateStudent up=new UpdateStudent();
		scontroller.updateStudent("abc", up);
		verify(sservice,times(1)).updateStudentDetails("abc", up);
	}
	
	@Test
	public void test_deleteStudent() {
		scontroller.deleteStudent("abc");
		verify(sservice,times(1)).deletestudent("abc");
	}

}
