package com.LMS.Learning_Management_System.DAO;

import org.springframework.data.repository.CrudRepository;

import com.LMS.Learning_Management_System.entities.Instructor;

public interface InstructorRepo extends CrudRepository<Instructor, String>{

}
