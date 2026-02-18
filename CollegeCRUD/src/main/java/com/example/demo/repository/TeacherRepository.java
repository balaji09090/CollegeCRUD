package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	Teacher findByMob(String Mob);
	
	boolean existsByName(String name);
	
	boolean existsByMob(String mob);
	
	boolean existsByEmail(String mob);
}
