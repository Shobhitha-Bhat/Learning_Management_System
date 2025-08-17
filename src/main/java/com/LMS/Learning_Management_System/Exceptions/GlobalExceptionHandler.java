package com.LMS.Learning_Management_System.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private ResponseEntity<ErrorResponseEntity> buildErrorResponse(Exception e, HttpStatus status){
		ErrorResponseEntity er = new ErrorResponseEntity(
				LocalDateTime.now(), 
				status.value(),
				e.getMessage(),
				"Couldn't Perform Required Operations.Try Again");
		return new ResponseEntity<ErrorResponseEntity>(er,status);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponseEntity> handleStudentNotFound(StudentNotFoundException e){
		return buildErrorResponse(e, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ErrorResponseEntity> handleCourseNotFound(CourseNotFoundException e){
		return buildErrorResponse(e, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InstructorNotFoundException.class)
	public ResponseEntity<ErrorResponseEntity> handleInstructorNotFound(InstructorNotFoundException e){
		return buildErrorResponse(e, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EnrollmentNotFoundException.class)
	public ResponseEntity<ErrorResponseEntity> handleEnrollmentNotFound(EnrollmentNotFoundException e){
		return buildErrorResponse(e, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidStudentException.class)
	public ResponseEntity<ErrorResponseEntity> handleInvalidStudent(InvalidStudentException e){
		return buildErrorResponse(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidInstructorException.class)
	public ResponseEntity<ErrorResponseEntity> handleInvalidInstructor(InvalidInstructorException e){
		return buildErrorResponse(e, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidCourseException.class)
	public ResponseEntity<ErrorResponseEntity> handleInvalidCourse(InvalidCourseException e){
		return buildErrorResponse(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidEnrollmentException.class)
	public ResponseEntity<ErrorResponseEntity> handleInvalidEnrollment(InvalidEnrollmentException e){
		return buildErrorResponse(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseEntity> fallbackMethod(Exception e){
		return buildErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
