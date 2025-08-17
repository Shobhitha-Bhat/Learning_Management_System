package com.LMS.Learning_Management_System.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.service.CourseService;


@ExtendWith(MockitoExtension.class)
class CourseControllerTest {
	private Course mockcourse() {
		return new Course();
	}
	@Mock
	private CourseService cservice;
	@InjectMocks
	private CourseController ccontroller;
	
	@Test
	public void test_addcourse() {
		ccontroller.addCourse(mockcourse());
		verify(cservice,times(1)).addCourse(mockcourse());
	}
	
	@Test
	public void test_getCourseById() {
		ccontroller.getCourseById(0);
		verify(cservice,times(1)).getInstructors(0);
	}
	
	@Test
	public void test_allcourses() {
		ccontroller.getAllCourses();
		verify(cservice,times(1)).getAllCourses();
	}
	
	@Test
	public void test_getCourseInstructors() {
		ccontroller.getCourseInstructors(0);
		verify(cservice,times(1)).getInstructors(0);
	}
	
	@Test
	public void test_addNewCourseInstructor() {
		ccontroller.addNewCourseInstructor(0, "abc");
		verify(cservice,times(1)).addNewCourseInst("abc", 0);
	}
	
	@Test
	public void test_deleteCourse() {
		ccontroller.deleteCourse(0);
		verify(cservice,times(1)).deletecourse(0);
	}
	

}
