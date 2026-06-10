package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}