package com.LMS.Learning_Management_System.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Learning_Management_System.DAO.CourseRepo;
import com.LMS.Learning_Management_System.DAO.InstructorRepo;
import com.LMS.Learning_Management_System.DAO.StudentRepo;
import com.LMS.Learning_Management_System.DTO.CourseReport;
import com.LMS.Learning_Management_System.DTO.InstructorCourseReport;
import com.LMS.Learning_Management_System.DTO.InstructorReport;
import com.LMS.Learning_Management_System.DTO.InstructorResponseEntity;
import com.LMS.Learning_Management_System.DTO.StudentCoursesReport;
import com.LMS.Learning_Management_System.DTO.StudentReport;
import com.LMS.Learning_Management_System.Exceptions.CourseNotFoundException;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.entities.Enrollments;
import com.LMS.Learning_Management_System.entities.Instructor;
import com.LMS.Learning_Management_System.entities.Student;

@Service
public class ReportService {
	@Autowired
	private StudentRepo strepo;
	@Autowired
	private InstructorRepo insrepo;
	@Autowired
	private CourseRepo crepo;
	
	public List<StudentReport> getStReport() {
		List<Student> students =(List<Student>) strepo.findAll();
		List<StudentReport> streport =new ArrayList<>();
		for(Student st: students) {	
			List<StudentCoursesReport> screport=new ArrayList<>();
			List<Enrollments> en =st.getEnrollments();
			int cid,marks,i=0;
			String cname;
			double average=0;
			for(Enrollments e:en) {
				cid= e.getEnr_id().getC_id();
				Course c=crepo.findById(cid).orElse(null);
				if(c==null)
					continue;   //the course might have been removed.
				cname=c.getC_name();
				marks =e.getMarks();
				average=average+marks;
				i++;
				screport.add(new StudentCoursesReport(cid,cname,marks));
			}
			average = (i > 0) ? average / i : 0.0;  //incase no enrollments
			streport.add(new StudentReport(st.getUsn(),st.getsName(),st.getDept(),st.getSemester(),average,screport));
		}
		return streport;
	}
	
	
	public List<InstructorReport> getInsReport(){
		//an instructor teaches many courses and a course can have many instructors.
		//so students enrolled in a particular course have nothing to do with the course instructor as of now
		List<Instructor> instructors = (List<Instructor>) insrepo.findAll();
		List<InstructorReport> ireport = new ArrayList<>();
		for(Instructor ins:instructors) {
			List<InstructorCourseReport> icreport = new ArrayList<>();
			List<Course> courses=ins.getCourses();
			long noOfStudents;
			double average;
			for(Course c:courses) {
				 noOfStudents = c.getEnrollments().stream().count();
				 average = c.getEnrollments().stream().mapToInt(enroll->enroll.getMarks()).average().orElse(0.0);	 
				 icreport.add(new InstructorCourseReport(c.getCid(),c.getC_name(),average,(int) noOfStudents));
			}
			ireport.add(new InstructorReport( ins.getFid(),ins.getFname(),ins.getDept(),icreport));
		}
		return ireport;
	}
	
	
	public List<CourseReport> getCReport(){
		List<Course> courses=(List<Course>)crepo.findAll();
		List<CourseReport> creport = new ArrayList<>();
		long noOfStudents;
		double average;
		for(Course c:courses) {
			List<InstructorResponseEntity> instructors=new ArrayList<>();
			noOfStudents = c.getEnrollments().stream().count();
			average = c.getEnrollments().stream().mapToInt(enroll->enroll.getMarks()).average().orElse(0.0);
			List<Instructor> ins = c.getInstructors();
			for(Instructor i:ins) {
				instructors.add(new InstructorResponseEntity(i.getFid(),i.getFname(),i.getDept()));
			}
			creport.add(new CourseReport(c.getCid(),c.getC_name(),instructors,(int) noOfStudents,average));
		}
		return creport;
		
	}
	

}
