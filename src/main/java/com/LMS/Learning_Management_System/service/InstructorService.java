package com.LMS.Learning_Management_System.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Learning_Management_System.DAO.CourseRepo;
import com.LMS.Learning_Management_System.DAO.InstructorRepo;
import com.LMS.Learning_Management_System.DTO.CourseResponseEntity;
import com.LMS.Learning_Management_System.DTO.FacultyCourseList;
import com.LMS.Learning_Management_System.Exceptions.CourseNotFoundException;
import com.LMS.Learning_Management_System.Exceptions.InstructorNotFoundException;
import com.LMS.Learning_Management_System.Exceptions.InvalidCourseException;
import com.LMS.Learning_Management_System.Exceptions.InvalidInstructorException;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.entities.Instructor;

@Service
public class InstructorService {
		@Autowired
		private InstructorRepo instrepo;

		@Autowired
		private CourseRepo crepo;
		
		//add faculty
		public Instructor addInstructor(Instructor ins) {
			Optional<Instructor> op= instrepo.findById(ins.getFid());
			if(op.isPresent()) {
				throw new InvalidInstructorException("Instructor with ID "+ins.getFid()+" already exists. Try Again");
			}
			return instrepo.save(ins);
		}
		
		
		//get faculty by id
		public Instructor getInsById(String fid) {
			Optional<Instructor> op =  instrepo.findById(fid);
			if(!op.isPresent()) {
				throw new InstructorNotFoundException("Instructor with ID "+fid+" not found.Try Again");
			}
			Instructor ins=op.get();
			return ins;
		}
		
		//get all faculty
		public List<FacultyCourseList> getAllInstructors(){
			List<Instructor> ins = (List<Instructor>) instrepo.findAll();
			List<FacultyCourseList> fc=new ArrayList<>();
			for(Instructor i:ins) {
				fc.add(getFacultyCourses(i.getFid()));
			}
			return fc;
			
		}
		
		
		//get the faculty handling courses list
		public FacultyCourseList getFacultyCourses(String fid){
			Instructor ins=getInsById(fid);
			List<CourseResponseEntity> list = ins.getCourses()
					.stream()
					.map(i-> new CourseResponseEntity(i.getCid(),i.getC_name()))
					.collect(Collectors.toList());
			
			return new FacultyCourseList(ins.getFid(),ins.getFname(),ins.getDept(),list);
		}
		
		//add course to be handled by the faculty
		public void addNewCourseForInst(String fId,int cId) {
			Optional<Course> op = crepo.findById(cId);
			if(!op.isPresent()) {
				throw new CourseNotFoundException("Course with ID "+cId+" not found.Try Again.");
			}
			Course c=op.get();
			Instructor ins=getInsById(fId);
			
			List<Course> cs = ins.getCourses();
			if(cs.contains(c)) {
				throw new InvalidCourseException("Course already handled by the Instructor. Try Again");
			}
			cs.add(c);
			ins.setCourses(cs);
			
			List<Instructor> i = c.getInstructors();
			i.add(ins);
			c.setInstructors(i);
			
			instrepo.save(ins);
			crepo.save(c);
			
		}
		
		public void deleteInst(String fid) {
			Optional<Instructor> op =  instrepo.findById(fid);
			if(!op.isPresent()) {
				throw new InstructorNotFoundException("Instructor with ID "+fid+" not found.Try Again");
			}
			//automatically deletes entry from the instructor_course join table also.
			instrepo.deleteById(fid);
		}
		
		
}
