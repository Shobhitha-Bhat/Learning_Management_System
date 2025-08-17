package com.LMS.Learning_Management_System.Exceptions;

public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException() {
		super();
	}	

	public StudentNotFoundException(String message) {
		super(message);
		
	}
	
}
