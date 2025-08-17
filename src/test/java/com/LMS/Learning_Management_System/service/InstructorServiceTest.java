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
import com.LMS.Learning_Management_System.DAO.InstructorRepo;
import com.LMS.Learning_Management_System.DTO.FacultyCourseList;
import com.LMS.Learning_Management_System.Exceptions.InstructorNotFoundException;
import com.LMS.Learning_Management_System.Exceptions.InvalidCourseException;
import com.LMS.Learning_Management_System.Exceptions.InvalidInstructorException;
import com.LMS.Learning_Management_System.entities.Course;
import com.LMS.Learning_Management_System.entities.Instructor;


@ExtendWith(MockitoExtension.class)
class InstructorServiceTest {

	private Instructor mockIns() {
		Instructor ins=new Instructor();
		ins.setFid("FA1");
		ins.setFname("abc");
		ins.setDept("cse");
		ins.setCourses(new ArrayList<>());
		return ins;
	}
	
	private Course mockcourse() {
		Course c=new Course();
		c.setCid(1);
		c.setC_name("abc");
		c.setEnrollments(new ArrayList<>());
		c.setInstructors(new ArrayList<>());
		return c;
	}
	
	@Mock
	private InstructorRepo irepo;
	@Mock
	private CourseRepo crepo;
	
	@InjectMocks
	private InstructorService iservice;
	
	@Test
	public void test_add_instructor() {
		//test if it already exists before adding -> ins_already_exists()
		Instructor ins=mockIns();
		when(irepo.findById(ins.getFid())).thenReturn(Optional.empty());
		when(irepo.save(ins)).thenReturn(ins);
		iservice.addInstructor(ins);
		verify(irepo,times(1)).save(ins);
	}
	
	
	@Test
	public void test_ins_already_exists(){
		Instructor ins=mockIns();
		when(irepo.findById(ins.getFid())).thenReturn(Optional.of(ins));
		
		assertThrows(InvalidInstructorException.class,()->{
			iservice.addInstructor(ins);
		});
	}
	
	@Test
	public void test_get_Ins() {
		Instructor ins=mockIns();
		when(irepo.findById(ins.getFid())).thenReturn(Optional.of(ins));
		iservice.getInsById(ins.getFid());
		verify(irepo,times(1)).findById(ins.getFid());
	}
	
	@Test
	public void test_get_Ins_notfound() {
		Instructor ins=mockIns();
		when(irepo.findById(ins.getFid())).thenReturn(Optional.empty());
		
		assertThrows(InstructorNotFoundException.class,()->{
			iservice.getInsById(ins.getFid());
		});
	}
	
	@Test
	public void test_get_all_courses() {
		Instructor ins1=mockIns();
		Instructor ins2=mockIns();
		List<Instructor> list=new ArrayList<>();
		list.add(ins1);
		list.add(ins2);
		
		when(irepo.findAll()).thenReturn(list);
		when(irepo.findById(ins1.getFid())).thenReturn(Optional.of(ins1));
		when(irepo.findById(ins2.getFid())).thenReturn(Optional.of(ins2));
		List<FacultyCourseList> result = iservice.getAllInstructors();
		verify(irepo,times(2)).findById(ins1.getFid());  //need not give ins1.id only , it just needs a matching type
		assertTrue(result.size()>0);
		
	}
	
	@Test
	public void test_addcourse_success() {
		Instructor i=mockIns();
		Course c=mockcourse();
		
		when(irepo.findById("FA1")).thenReturn(Optional.of(i));
		when(crepo.findById(1)).thenReturn(Optional.of(c));
		
		iservice.addNewCourseForInst("FA1", 1);
		assertTrue(i.getCourses().contains(c));
		assertTrue(c.getInstructors().contains(i));
		
		verify(irepo,times(1)).save(i);
		verify(crepo,times(1)).save(c);
		
		//testcases for cases when course or instructor not found, already tested.
	}
	
	@Test
	public void test_addcourse_already_handlingcourse() {
		Instructor i=mockIns();
		Course c=mockcourse();
		i.setCourses(List.of(c));
		
		when(irepo.findById("FA1")).thenReturn(Optional.of(i));
		when(crepo.findById(1)).thenReturn(Optional.of(c));
		
		assertThrows(InvalidCourseException.class,()->{
			iservice.addNewCourseForInst("FA1", 1);
	});
	}
	
	@Test
	public void test_delete() {
		Instructor i=mockIns();
		when(irepo.findById("FA1")).thenReturn(Optional.of(i));
		iservice.deleteInst(i.getFid());
		verify(irepo,times(1)).deleteById(i.getFid());
	}
	
}
