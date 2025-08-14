package com.LMS.Learning_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Learning_Management_System.DAO.CourseRepo;
import com.LMS.Learning_Management_System.DAO.InstructorRepo;
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
			return instrepo.save(ins);
		}
		
		
		//get faculty by id
		public Instructor getInsById(String fid) {
			Optional<Instructor> op =  instrepo.findById(fid);
			Instructor ins=op.get();
			return ins;
		}
		
		//get all faculty
		public List<Instructor> getAllInstructors(){
			return (List<Instructor>) instrepo.findAll();
		}
		
		
		//get the faculty handling courses list
		public List<Course> getFacultyCourses(String fid){
			Instructor ins=getInsById(fid);
			return ins.getCourses();
		}
		
		//add course to be handled by the faculty
		public void addNewCourseForInst(String fId,int cId) {
			Optional<Course> op = crepo.findById(cId);
			Course c=op.get();
			Instructor ins=getInsById(fId);
			
			List<Course> cs = ins.getCourses();
			cs.add(c);
			ins.setCourses(cs);
			
			List<Instructor> i = c.getInstructors();
			i.add(ins);
			c.setInstructors(i);
			
			instrepo.save(ins);
			crepo.save(c);
			
		}
		
		
}
