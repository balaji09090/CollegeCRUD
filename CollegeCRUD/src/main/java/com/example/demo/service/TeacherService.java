package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TeacherDtoRequest;
import com.example.demo.dto.TeacherDtoResponse;
import com.example.demo.model.Teacher;

public interface TeacherService {
	
	void add(TeacherDtoRequest t);

	List<TeacherDtoResponse> display();
	
	TeacherDtoResponse delete(Integer id);
	
	TeacherDtoResponse update(Teacher teacher, Integer id);
	
	TeacherDtoResponse search(Integer id);
	
	void addAll(List<Teacher> list);
	
	
}
