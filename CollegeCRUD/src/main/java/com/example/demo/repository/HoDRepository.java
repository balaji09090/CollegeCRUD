package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.HoD;

public interface HoDRepository extends JpaRepository<HoD, Integer>{

	boolean existsById(Integer id);
	
	boolean existsByMob(String mob);

	boolean existsByEmail(String email);
	
}
