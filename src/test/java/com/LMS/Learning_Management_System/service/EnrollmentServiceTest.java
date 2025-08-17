package com.LMS.Learning_Management_System.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.LMS.Learning_Management_System.DAO.CourseRepo;
import com.LMS.Learning_Management_System.DAO.EnrollmentRepo;
import com.LMS.Learning_Management_System.DAO.StudentRepo;
import com.LMS.Learning_Management_System.DTO.EnrollmentRequest;
import com.LMS.Learning_Management_System.DTO.UpdateEnrollment;
import com.LMS.Learning_Management_System.Exceptions.EnrollmentNotFoundException;
import com.LMS.Learning_Management_System.Exceptions.InvalidEnrollmentException;
import com.LMS.Learning_Management_System.Exceptions.InvalidInstructorException;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.entities.EnrollmentId;
import com.LMS.Learning_Management_System.entities.Enrollments;
import com.LMS.Learning_Management_System.entities.Student;

@ExtendWith(MockitoExtension.class)
class EnrollmentServiceTest {
	
	private Enrollments getMockEnrollments() {
		Student student = new Student();
		student.setUsn("S101");

		Course course = new Course();
		course.setCid(1);

		EnrollmentId enrId = new EnrollmentId();
		enrId.setUsn(student.getUsn());
		enrId.setC_id(course.getCid());

		Enrollments enrollment = new Enrollments(enrId, student, course, 95);
		return enrollment;
	}
	
	private EnrollmentId getMockEnrollmetId() {
		Student student = new Student();
		student.setUsn("S101");

		Course course = new Course();
		course.setCid(1);

		EnrollmentId enrId = new EnrollmentId();
		enrId.setUsn(student.getUsn());
		enrId.setC_id(course.getCid());
		
		return enrId;
	}
	
	private Student mockStudent() {
		Student st=new Student();
		st.setUsn("S101");
		st.setEnrollments(new ArrayList<>());
		return st;
	}
	
	private Course mockCourse() {
		Course c=new Course();
		c.setCid(0);
		c.setEnrollments(new ArrayList<>());
		return c;
	}
	
	private Course mockCourseid(int cid) {
		Course c=new Course();
		c.setCid(cid);
		c.setEnrollments(new ArrayList<>());
		return c;
	}
	
	
	@Mock
	private EnrollmentRepo enrepo;
	@Mock
	private CourseRepo crepo;
	@Mock
	private StudentService stservice;
	@Mock
	private CourseService cservice;
	@InjectMocks
	private EnrollmentService enservice;
	
	@Test
	public void test_allEnrollments() {
		List<Enrollments> enrolls=new ArrayList<>();
		enrolls.add(getMockEnrollments());
		when(enrepo.findAllByCourse_cid(1)).thenReturn(enrolls);
		
		enservice.getAllStudentsInCourse(1);
		verify(enrepo,times(1)).findAllByCourse_cid(1);
	}
	
	@Test
	public void test_addEnrollment_success() {
		Enrollments en=getMockEnrollments();
		EnrollmentId eid=getMockEnrollmetId();
		Student st=mockStudent();
		Course c=mockCourse();
		when(stservice.getStudentById("S101")).thenReturn(st);
		when(cservice.getCourseById(1)).thenReturn(c);
		when(enrepo.findById(eid)).thenReturn(Optional.empty());
		enservice.addStudentCourse("S101", 1);
		

		assertTrue(st.getEnrollments().size()>0);
		
	}
	
	@Test
	public void test_addEnrollment_enroll_exists() {
		Enrollments en=getMockEnrollments();
		EnrollmentId eid=getMockEnrollmetId();
		Student st=mockStudent();
		Course c=mockCourse();
		when(stservice.getStudentById("S101")).thenReturn(st);
		when(cservice.getCourseById(1)).thenReturn(c);
		when(enrepo.findById(eid)).thenReturn(Optional.of(en));
		
		assertThrows(InvalidEnrollmentException.class,()->{
			enservice.addStudentCourse("S101", 1);
		});
	}
	
	@Test
	public void test_addEnrollmenst_list() {
		
		List<Integer> mock_course_list = new ArrayList<>();
		mock_course_list.add(1);
		mock_course_list.add(2);
		mock_course_list.add(3);
		
		EnrollmentRequest enreq = new EnrollmentRequest();
		enreq.setStUSN("S101");
		enreq.setCourseIds(mock_course_list);
		
		for(Integer i: mock_course_list) {
			when(cservice.getCourseById(i)).thenReturn(mockCourseid(i));
		}
		Student st=mockStudent();
		when(stservice.getStudentById("S101")).thenReturn(st);
		
		when(enrepo.findById(getMockEnrollmetId())).thenReturn(Optional.empty());  //empty, bcs we assume that there is no such entry already present
//	every time a new course checked we can test if that enr_id is already present or not
		enservice.addStudentsandTheirCourses(enreq);
		verify(enrepo,times(3)).save(any(Enrollments.class));
	}
	
	
	@Test
	public void test_updateMarks() {
		UpdateEnrollment upen=new UpdateEnrollment();
		upen.setcId(1);
		upen.setStUsn("S101");
		upen.setMarks(100);
		Enrollments en=getMockEnrollments();
		when(enrepo.findById(getMockEnrollmetId())).thenReturn(Optional.of(en));
		enservice.modifyStudentMarks(upen);
		assertThat(100).isEqualTo(en.getMarks());
	}
	
	@Test
	public void test_enr_id_not_found() {
		UpdateEnrollment upen=new UpdateEnrollment();
		upen.setcId(1);
		upen.setStUsn("S101");
		upen.setMarks(100);
		when(enrepo.findById(getMockEnrollmetId())).thenReturn(Optional.empty());
		
		assertThrows(EnrollmentNotFoundException.class,()->{
			enservice.modifyStudentMarks(upen);
	});

	}
	
	@Test
	public void test_delete() {
		//checking if the mentioned enr_id is present or no, is already done in enr_id_not_found() method
		when(enrepo.findById(getMockEnrollmetId())).thenReturn(Optional.of(getMockEnrollments()));
		enservice.deleteEnrollment("S101",1 );
		verify(enrepo,times(1)).deleteById(getMockEnrollmetId());
	}

	

}
