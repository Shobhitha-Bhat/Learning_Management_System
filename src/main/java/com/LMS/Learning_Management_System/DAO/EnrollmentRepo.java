package com.LMS.Learning_Management_System.DAO;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.LMS.Learning_Management_System.entities.EnrollmentId;
import com.LMS.Learning_Management_System.entities.Enrollments;


public interface EnrollmentRepo extends CrudRepository<Enrollments, EnrollmentId> {
		List<Enrollments> findAllByCourse_cid(int c_id);
		void deleteAllByCourse_cid(int c_id);
}
