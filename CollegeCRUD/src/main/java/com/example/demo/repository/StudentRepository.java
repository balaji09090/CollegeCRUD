package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	boolean existsByRoll(Integer roll);
	
	boolean existsByName(String name);
	
	boolean existsByEmail(String name);
	
	boolean existsByPassword(String name);
}
