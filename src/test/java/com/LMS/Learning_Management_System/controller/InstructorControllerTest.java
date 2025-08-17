package com.LMS.Learning_Management_System.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.LMS.Learning_Management_System.entities.Instructor;
import com.LMS.Learning_Management_System.service.InstructorService;

@ExtendWith(MockitoExtension.class)
class InstructorControllerTest {

	@Mock
	private InstructorService iservice;
	@InjectMocks
	private InstructorController icontroller;
	
	@Test
	public void test_addInstructor() {
		Instructor i=new Instructor();
		icontroller.addInstructor(i);
		verify(iservice,times(1)).addInstructor(i);
	}
	
	@Test
	public void test_getAllInstructors() {
		icontroller.getAllInstructors();
		verify(iservice,times(1)).getAllInstructors();
	}
	
	@Test
	public void test_getInstructorById() {
		icontroller.getInstructorById("abc");
		verify(iservice,times(1)).getFacultyCourses("abc");
	}
	
	@Test
	public void test_addNewCourse() {
		icontroller.addNewCourse("abc", 0);
		verify(iservice,times(1)).addNewCourseForInst("abc", 0);
	}
	
	@Test
	public void test_deleteInstructor() {
		icontroller.deleteInstructor("abc");
		verify(iservice,times(1)).deleteInst("abc");
	}

}
