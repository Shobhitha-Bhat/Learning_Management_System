package com.LMS.Learning_Management_System.service;

import static org.assertj.core.api.Assertions.assertThat;
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

import com.LMS.Learning_Management_System.DAO.StudentRepo;
import com.LMS.Learning_Management_System.DTO.StudentEnrollments;
import com.LMS.Learning_Management_System.DTO.UpdateStudent;
import com.LMS.Learning_Management_System.Exceptions.InvalidInstructorException;
import com.LMS.Learning_Management_System.Exceptions.InvalidStudentException;
import com.LMS.Learning_Management_System.Exceptions.StudentNotFoundException;
import com.LMS.Learning_Management_System.entities.Student;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
	
	private Student mockSt() {
		Student st=new Student();
		st.setUsn("S101");
		st.setsName("abc");
		st.setDept("cse");
		st.setSemester(7);
		st.setEnrollments(new ArrayList<>());
		return st;
	}
	
	
	@Mock
	private StudentRepo srepo;
	
	@InjectMocks
	private StudentService sservice;
	
	@Test
	public void test_addStudent() {
		Student st=mockSt();
		when(srepo.save(st)).thenReturn(st);
		sservice.addStudent(st);
		verify(srepo,times(1)).save(st);
	}
	
	@Test
	public void test_alreadypresentstudent() {
		Student st=mockSt();
		when(srepo.findById(st.getUsn())).thenReturn(Optional.of(st));
		assertThrows(InvalidStudentException.class,()->{
			sservice.addStudent(st);
		});
	}
	
	@Test
	public void test_find_Student(){
		Student st=mockSt();
		when(srepo.findById(st.getUsn())).thenReturn(Optional.empty());
		assertThrows(StudentNotFoundException.class,()->{
			sservice.getStudentById(st.getUsn());
		});
	}

	@Test
	public void test_getallStudents() {
		Student st=mockSt();
		List<Student> students=new ArrayList<>();
		students.add(st);
		
		when(srepo.findAll()).thenReturn(students);
		when(srepo.findById(st.getUsn())).thenReturn(Optional.of(st));
		
		List<StudentEnrollments> result = sservice.getAllStudents();
		verify(srepo,times(1)).findById(st.getUsn());
		assertTrue(result.size()>0);
	}
	
	@Test
	public void test_updateStudentDetails() {
		Student st=mockSt();
		UpdateStudent up=new UpdateStudent();
		up.setsName("newname");  //just to test if updated or not in the result
		
		when(srepo.findById(st.getUsn())).thenReturn(Optional.of(st));
		//if it returns empty that means no student so cant update
		when(srepo.save(st)).thenReturn(st);
		sservice.updateStudentDetails("S101", up);
		assertThat(up.getsName()).isEqualTo(st.getsName());
	}
	
	
	@Test
	public void test_delete() {
		Student st=mockSt();
		when(srepo.findById(st.getUsn())).thenReturn(Optional.of(st));
		sservice.deletestudent(st.getUsn());
		verify(srepo,times(1)).deleteById(st.getUsn());
	}

}
