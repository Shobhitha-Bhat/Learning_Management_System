package com.LMS.Learning_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Learning_Management_System.DAO.CourseRepo;
import com.LMS.Learning_Management_System.DAO.EnrollmentRepo;
import com.LMS.Learning_Management_System.DAO.StudentRepo;
import com.LMS.Learning_Management_System.DTO.EnrollmentRequest;
import com.LMS.Learning_Management_System.DTO.UpdateEnrollment;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.entities.EnrollmentId;
import com.LMS.Learning_Management_System.entities.Enrollments;
import com.LMS.Learning_Management_System.entities.Student;

@Service
public class EnrollmentService {
	
	@Autowired
	private EnrollmentRepo enrepo;
	@Autowired
	private StudentService stservice;
	@Autowired
	private CourseService cservice;
	
	//get all students enrolled in a particular course	
	public List<Enrollments> getAllStudentsInCourse(int c_id){
		List<Enrollments> enrolls = (List<Enrollments>) enrepo.findAllByCourse_cid(c_id);
		return enrolls;
	}
	
//	//get a particular student in a particular course
//	public Student getStudentInCourse(String usn,int c_id) {
//		Optional<Student> op=enrepo.findStudentInCourse(usn,c_id);
//		Student s=op.get();
//		return s;
//	}

	
	
	//add a student and their selected course(not a list)
	
	public Enrollments addStudentCourse(String usn,int c_id) {
		Student st = stservice.getStudentById(usn);
		Course c = cservice.getCourseById(c_id);
		
		EnrollmentId newEnroll = new EnrollmentId(usn,c_id);
		
		Enrollments enroll = new Enrollments(newEnroll, st,c,0);
		return enrepo.save(enroll);
		
	}
	

	//add a student and their selected courses_list
	public void addStudentsandTheirCourses(EnrollmentRequest enreq) {
		String usn=enreq.getSt_USN();
		List<Integer> course_ids = enreq.getCourse_ids();
		Student st = stservice.getStudentById(usn);
		for(Integer c_id:course_ids) {
			
			Course c = cservice.getCourseById(c_id);
			
			EnrollmentId newEnroll = new EnrollmentId(usn,c_id);
			
			Enrollments enroll = new Enrollments(newEnroll, st,c,0);
			enrepo.save(enroll);
		}
	}
	
	
	
	//add/update marks of a particular course and student
	
	public void modifyStudentMarks(UpdateEnrollment upenroll) {
		String Usn=upenroll.getStUsn();
		int c_id = upenroll.getcId();
		int marks=upenroll.getMarks();
		EnrollmentId enroll = new EnrollmentId(Usn,c_id);
		Optional<Enrollments> optional = enrepo.findById(enroll);
		
		Enrollments en=optional.get();
		en.setMarks(marks);
		enrepo.save(en);
	}
	
	
	//delete a particular entry	
	public void deleteEnrollment(String usn,int c_id) {
		EnrollmentId e_id=new EnrollmentId(usn,c_id);
		enrepo.deleteById(e_id);
	}
	

	
	

}
