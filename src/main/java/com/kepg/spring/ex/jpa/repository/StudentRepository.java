package com.kepg.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kepg.spring.ex.jpa.student.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
