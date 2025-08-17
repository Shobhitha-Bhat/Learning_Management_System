package com.LMS.Learning_Management_System.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.LMS.Learning_Management_System.DTO.EnrollmentRequest;
import com.LMS.Learning_Management_System.DTO.UpdateEnrollment;
import com.LMS.Learning_Management_System.service.EnrollmentService;

@ExtendWith(MockitoExtension.class)
class EnrollmentControllerTest {
	@Mock
	private EnrollmentService enservice;
	
	@InjectMocks
	private EnrollmentController econtroller;
	
	@Test
	public void test_getAllEnrollments() {
		econtroller.getAllEnrollments(0);
		verify(enservice,times(1)).getAllStudentsInCourse(0);
	}
	
	@Test
	public void test_addEnrollment() {
		econtroller.addEnrollment("abc", 0);
		verify(enservice,times(1)).addStudentCourse("abc", 0);
	}
	
	@Test
	public void test_addManyEnrollments() {
		EnrollmentRequest e =new EnrollmentRequest();
		econtroller.addManyEnrollments(e);
		verify(enservice,times(1)).addStudentsandTheirCourses(e);
	}
	
	@Test
	public void test_updatEnrollment() {
		UpdateEnrollment e= new UpdateEnrollment();
		econtroller.updatEnrollment(e);
		verify(enservice,times(1)).modifyStudentMarks(e);
	}
	
	@Test
	public void test_delete() {
		econtroller.deleteEnrollment("abc", 0);
		verify(enservice,times(1)).deleteEnrollment("abc", 0);
	}

	

}
