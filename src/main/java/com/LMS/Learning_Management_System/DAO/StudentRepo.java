package com.LMS.Learning_Management_System.DAO;

import org.springframework.data.repository.CrudRepository;

import com.LMS.Learning_Management_System.entities.Student;

public interface StudentRepo extends CrudRepository<Student, String> {

}
