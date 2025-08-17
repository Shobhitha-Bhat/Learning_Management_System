package com.LMS.Learning_Management_System.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Learning_Management_System.DAO.StudentRepo;
import com.LMS.Learning_Management_System.DTO.StudentEnrollments;
import com.LMS.Learning_Management_System.DTO.UpdateStudent;
import com.LMS.Learning_Management_System.Exceptions.InvalidStudentException;
import com.LMS.Learning_Management_System.Exceptions.StudentNotFoundException;
import com.LMS.Learning_Management_System.entities.Enrollments;
import com.LMS.Learning_Management_System.entities.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepo strepo;

	
	//add student
	public Student addStudent(Student st) {
		strepo.findById(st.getUsn()).
			ifPresent(e->{
			throw new InvalidStudentException("Student with USN "+st.getUsn()+" already exists.Try Again");
			});
		return strepo.save(st);
	}

	
	//get student by id	
	public Student getStudentById(String usn) {
		return strepo.findById(usn).
					orElseThrow(()->new StudentNotFoundException("Student with USN "+usn+" not found. Try Again"));
	}
	
	
	public StudentEnrollments getStudentDetailsById(String usn) {
//		Optional<Student> op=strepo.findById(usn);
//		if(!op.isPresent()) {
////			error
//		}
//		Student st=op.get();
		Student st=getStudentById(usn);
		List<Enrollments> en=st.getEnrollments();
		StudentEnrollments se=new StudentEnrollments();
		se.setUsn(st.getUsn());
		se.setsName(st.getsName());
		se.setSemester(st.getSemester());
		for(Enrollments e:en) {
			se.getCourseIds().add(e.getEnr_id().getC_id());
		}
		return se;
	}
	
	//get all students
	public List<StudentEnrollments> getAllStudents(){
		List<Student> allst = (List<Student>) strepo.findAll();
		List<StudentEnrollments> sten=new ArrayList<>();
		for(Student st:allst) {
			sten.add(getStudentDetailsById(st.getUsn()));
		}
		return sten;
	}
	
	//only student details
	public void updateStudentDetails(String usn,UpdateStudent st) {
		Student s=getStudentById(usn);
		s.setsName(st.getsName());
		s.setSemester(st.getSemester());
		s.setDept(st.getDept());
		strepo.save(s);
	}
	
	//used by enrollmentservice to save/ update new enrolled courses
	public void updateStudent(Student s) {
		strepo.save(s);
	}
	
	
	public void deletestudent(String usn) {
		//delete all children referring to this field before deleting parent
		//this is done by cascade
		getStudentById(usn);
		strepo.deleteById(usn);
	}
	
	
	
}
