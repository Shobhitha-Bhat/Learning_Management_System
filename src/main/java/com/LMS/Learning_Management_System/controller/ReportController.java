package com.LMS.Learning_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.Learning_Management_System.DTO.CourseReport;
import com.LMS.Learning_Management_System.DTO.InstructorReport;
import com.LMS.Learning_Management_System.DTO.StudentReport;
import com.LMS.Learning_Management_System.service.ReportService;

@RestController
public class ReportController {
	@Autowired
	private ReportService rpservice;
	
	@GetMapping("/studentReport")
	public List<StudentReport> getStudentReport() {
		return rpservice.getStReport();
	}
	
	
	@GetMapping("/instructorReport")
	public List<InstructorReport> getInstructorReport(){
		return rpservice.getInsReport();
	}
	
	@GetMapping("/courseReport")
	public List<CourseReport> getCourseReport(){
		return rpservice.getCReport();
	}
	
}
