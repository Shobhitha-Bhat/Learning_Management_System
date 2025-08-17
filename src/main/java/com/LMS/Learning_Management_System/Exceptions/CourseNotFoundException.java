package com.LMS.Learning_Management_System.Exceptions;

public class CourseNotFoundException extends RuntimeException{

	public CourseNotFoundException() {
		super();
		
	}

	public CourseNotFoundException(String message) {
		super(message);
		
	}

}
