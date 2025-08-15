package com.LMS.Learning_Management_System.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Learning_Management_System.DAO.CourseRepo;
import com.LMS.Learning_Management_System.DAO.InstructorRepo;
import com.LMS.Learning_Management_System.DTO.CourseFacultyList;
import com.LMS.Learning_Management_System.DTO.InstructorResponseEntity;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.entities.Instructor;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepo crepo;
	@Autowired
	private InstructorRepo irepo;
	
	//add course
	public Course addCourse(Course c) {
		return crepo.save(c);
	}
	
	//get a course detail with id;
	public Course getCourseById(int c_id) {
	Optional<Course> op= crepo.findById(c_id);
	if(!op.isPresent()) {
//		error
	}
	Course c= op.get();
	return c;
	}
	
	//get all course with details
	public List<Course> getAllCourses(){
		List<Course> allcourses = (List<Course>) crepo.findAll();
		return allcourses;
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
}
