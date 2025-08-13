package com.LMS.Learning_Management_System.DAO;

import org.springframework.data.repository.CrudRepository;

import com.LMS.Learning_Management_System.entities.EnrollmentId;
import com.LMS.Learning_Management_System.entities.Enrollments;

public interface EnrollmentRepo extends CrudRepository<Enrollments, EnrollmentId> {

}
