package com.LMS.Learning_Management_System.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.LMS.Learning_Management_System.entities.EnrollmentId;
import com.LMS.Learning_Management_System.entities.Enrollments;
import com.LMS.Learning_Management_System.entities.Student;

public interface EnrollmentRepo extends CrudRepository<Enrollments, EnrollmentId> {
		List<Enrollments> findAllByCourse_cid(int c_id);
		void deleteAllByCourse_cid(int c_id);
}
