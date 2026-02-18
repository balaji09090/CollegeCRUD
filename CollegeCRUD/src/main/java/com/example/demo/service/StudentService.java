package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDtoRequest;
import com.example.demo.dto.StudentDtoResponse;
import com.example.demo.model.Student;

public interface StudentService {
	
	void add(StudentDtoRequest student);
	
	List<StudentDtoResponse> display();
	
	StudentDtoResponse delete(Integer roll);
	
	StudentDtoResponse update(Student student, Integer roll);
	
	StudentDtoResponse search(Integer roll);
	
	void addAll(List<Student> list);
	
	
}
