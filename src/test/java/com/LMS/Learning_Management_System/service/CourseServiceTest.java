package com.LMS.Learning_Management_System.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.LMS.Learning_Management_System.DAO.CourseRepo;
import com.LMS.Learning_Management_System.DAO.EnrollmentRepo;
import com.LMS.Learning_Management_System.DAO.InstructorRepo;
import com.LMS.Learning_Management_System.DTO.CourseFacultyList;
import com.LMS.Learning_Management_System.Exceptions.InstructorNotFoundException;
import com.LMS.Learning_Management_System.Exceptions.InvalidCourseException;
import com.LMS.Learning_Management_System.Exceptions.InvalidInstructorException;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.entities.Instructor;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {
	
	@Mock
	private CourseRepo crepo;
	@Mock
	private InstructorRepo insrepo;
	@Mock
	private EnrollmentRepo enrepo;
	
	@InjectMocks
	private CourseService cservice;
	
private Course getMockCourseObject() {
	Course mockcourse = new Course();
	mockcourse.setCid(1);
	mockcourse.setC_name("mockname");
	Instructor inst1 = new Instructor();
	inst1.setFid("FA02");
	inst1.setFname("FAC-xyz");
	inst1.setDept("CSE");
	List<Course> courses = new ArrayList<>();
    courses.add(mockcourse);
    inst1.setCourses(courses);
    
	List<Instructor> instructors = new ArrayList<>();
	instructors.add(inst1);
	mockcourse.setInstructors(instructors);
	return mockcourse;
}


private Instructor getmockInstructor() {
	Instructor mockins=new Instructor();
	mockins.setFid("FA02");
	mockins.setFname("FAC-xyz");
	mockins.setDept("CSE");
	
	Course mockcourse = new Course();
	mockcourse.setCid(1);
	mockcourse.setC_name("mockname");
	List<Course> courses = new ArrayList<>();
	courses.add(mockcourse);
	mockins.setCourses(courses);
	return mockins;
}

private Instructor getmockInstructor2() {
	Instructor mockins=new Instructor();
	mockins.setFid("FA00");
	mockins.setFname("FAC-xyz");
	mockins.setDept("CSE");
	
	Course mockcourse = new Course();
	mockcourse.setCid(1);
	mockcourse.setC_name("mockname");
	List<Course> courses = new ArrayList<>();
	courses.add(mockcourse);
	mockins.setCourses(courses);
	return mockins;
}


	@Test
	public void test_addCourse() {
		Course mockcourse = new Course();
		mockcourse.setCid(1);
		mockcourse.setC_name("mockname");
		when(crepo.findById(mockcourse.getCid())).thenReturn(Optional.empty());
		when(crepo.save(mockcourse)).thenReturn(mockcourse);
		
		cservice.addCourse(mockcourse);
		verify(crepo,times(1)).save(mockcourse);
	}
	
	@Test
	public void course_present() {
		Course mockcourse = new Course();
		mockcourse.setCid(1);
		mockcourse.setC_name("mockname");
		when(crepo.findById(mockcourse.getCid())).thenReturn(Optional.of(mockcourse));
		assertThrows(InvalidCourseException.class,()->{
			cservice.addCourse(mockcourse);
		});
	}
	
	
	@Test
	public void test_getCourse() {
		Course mockcourse = getMockCourseObject();
		when(crepo.findById(1)).thenReturn(Optional.of(mockcourse));
		cservice.getCourseById(1);
		verify(crepo,times(1)).findById(1);
	}
	
	@Test
	public void test_getAllCourses() {
		Course c=getMockCourseObject();
		when(crepo.findById(1)).thenReturn(Optional.of(c));
		List<Course> courses=new ArrayList<>();
		courses.add(getMockCourseObject());
		when(crepo.findAll()).thenReturn(courses);
		cservice.getAllCourses();
		verify(crepo,times(1)).findAll();
	}
	
	@Test
	public void test_coursefaculties() {
		Course c=getMockCourseObject();
		when(crepo.findById(1)).thenReturn(Optional.of(c));
		CourseFacultyList res = cservice.getInstructors(1);
		assertEquals(c.getCid(), res.getcId());
				
	}
	
	@Test
	public void test_addinstructor_success() {
		Course c=getMockCourseObject();
		Instructor ins=getmockInstructor2();
		
		when(crepo.findById(1)).thenReturn(Optional.of(c));
		when(insrepo.findById("FA00")).thenReturn(Optional.of(ins));
		
		cservice.addNewCourseInst( "FA00",1);
		assertTrue(c.getInstructors().contains(ins));
		assertTrue(ins.getCourses().contains(c));
		
		verify(crepo,times(1)).save(c);
		verify(insrepo,times(1)).save(ins);
		
	}
	
	@Test
	public void test_addinstructor_ins_notfound() {
		//course not found already tested in test_getCourse
		Course c=getMockCourseObject();
		when(crepo.findById(1)).thenReturn(Optional.of(c));
		when(insrepo.findById("FA99")).thenReturn(Optional.empty());
		
		//we are asserting that the below execution will throw an exception.
		assertThrows(InstructorNotFoundException.class,()->{
			cservice.addNewCourseInst("FA99", 1);
		});
		
	}
	
	@Test
	public void test_addinstructor_ins_alreadyexists() {
		Course c=getMockCourseObject();
		Instructor ins=getmockInstructor();
		when(crepo.findById(1)).thenReturn(Optional.of(c));
		when(insrepo.findById("FA02")).thenReturn(Optional.of(ins));
		
		//we are asserting that the below execution will throw an exception.
		assertThrows(InvalidInstructorException.class,()->{
			cservice.addNewCourseInst("FA02", 1);
	});
	}
	
	
	@Test
	public void test_delete() {
		Course c=getMockCourseObject();
		Instructor ins=c.getInstructors().get(0);
		
		when(crepo.findById(1)).thenReturn(Optional.of(c));
		cservice.deletecourse(1);
		
		assertFalse(ins.getCourses().contains(c));
		verify(enrepo,times(1)).deleteAllByCourse_cid(1);
		verify(crepo,times(1)).deleteById(1);
	}

	

}
