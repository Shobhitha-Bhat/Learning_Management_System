package com.LMS.Learning_Management_System.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.LMS.Learning_Management_System.service.ReportService;

@ExtendWith(MockitoExtension.class)
class ReportControllerTest {

	@Mock
	private ReportService rps;
	@InjectMocks
	private ReportController rpc;
	
	@Test
	public void test_getStudentReport() {
		rpc.getStudentReport();
		verify(rps,times(1)).getStReport();
	}
	@Test
	public void test_getCourseReport() {
		rpc.getCourseReport();
		verify(rps,times(1)).getCReport();
	}
	@Test
	public void test_getInsReport() {
		rpc.getInstructorReport();
		verify(rps,times(1)).getInsReport();
	}
	
}
