package com.LMS.Learning_Management_System.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Learning_Management_System.DAO.CourseRepo;
import com.LMS.Learning_Management_System.DAO.EnrollmentRepo;
import com.LMS.Learning_Management_System.DAO.InstructorRepo;
import com.LMS.Learning_Management_System.DTO.CourseFacultyList;
import com.LMS.Learning_Management_System.DTO.InstructorResponseEntity;
import com.LMS.Learning_Management_System.Exceptions.CourseNotFoundException;
import com.LMS.Learning_Management_System.Exceptions.InstructorNotFoundException;
import com.LMS.Learning_Management_System.Exceptions.InvalidCourseException;
import com.LMS.Learning_Management_System.Exceptions.InvalidInstructorException;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.entities.Instructor;

import jakarta.transaction.Transactional;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepo crepo;
	@Autowired
	private InstructorRepo irepo;
	@Autowired
	private EnrollmentRepo enrepo;
	
	//add course
	public Course addCourse(Course c) {
		Optional<Course> op= crepo.findById(c.getCid());
		if(op.isPresent()) {
			throw new InvalidCourseException("Course with ID "+c.getCid()+" already exists. Try Again");
		}
		return crepo.save(c);
	}
	
	//get a course detail with id;
	public Course getCourseById(int c_id) {
	Optional<Course> op= crepo.findById(c_id);
	if(!op.isPresent()) {
		throw new CourseNotFoundException("Course with ID "+c_id+" not found.Try Again.");
	}
	Course c= op.get();
	return c;
	}
	
	
	//get all course with details
	public List<CourseFacultyList> getAllCourses(){
		List<Course> allcourses = (List<Course>) crepo.findAll();
		List<CourseFacultyList> cf = new ArrayList<>();
		for(Course c:allcourses) {
			cf.add(getInstructors(c.getCid()));
		}
		return cf;
	}
	
	
	//get the course handling faculty list
	public CourseFacultyList getInstructors(int c_id){
		Course c = getCourseById(c_id);
		List<InstructorResponseEntity> list = c.getInstructors()
				.stream()
				.map(i -> new InstructorResponseEntity(i.getFid(),i.getFname(),i.getDept()))
				.collect(Collectors.toList());
		return new CourseFacultyList(c.getCid(),c.getC_name(),list);
	}
	
	
	//add a new courseInstructor
	public void addNewCourseInst(String fId,int c_id) {
		Course c = getCourseById(c_id);
		Optional<Instructor> op=irepo.findById(fId);
		if(!op.isPresent()) {
			throw new InstructorNotFoundException("Instructor with ID "+fId+" not found.Try Again");
		}
		Instructor ins=op.get();
		
		List<Instructor> inst = c.getInstructors();
		inst.add(ins);
		c.setInstructors(inst);
		List<Course> cs=ins.getCourses();
		cs.add(c);
		ins.setCourses(cs);
		
		crepo.save(c);
		irepo.save(ins);
	}
	
	@Transactional
	public void deletecourse(int cid) {
		//delete students who have enrolled into that particular course
		enrepo.deleteAllByCourse_cid(cid);
		Course c =getCourseById(cid);
		//delete the course from the course list of faculty
		for (Instructor i : c.getInstructors()) {
	        i.getCourses().remove(c);
	    }
		//clear the faculty list of that particular course.....not needed..already deleted from the facultyside
//	    c.getInstructors().clear();
//		crepo.saveAndFlush(c);   //requires jparepo
		crepo.deleteById(cid);
	}
}
