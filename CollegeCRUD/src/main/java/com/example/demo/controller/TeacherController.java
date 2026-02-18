	package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TeacherDtoRequest;
import com.example.demo.dto.TeacherDtoResponse;
import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;

@RestController
@RequestMapping("teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService ts;
	
	@PostMapping("add")
	public void add(@RequestBody TeacherDtoRequest t) {
		ts.add(t);
	}
	@GetMapping("display")
	public List<TeacherDtoResponse> display() {
		return ts.display();
	}
	
	@DeleteMapping("delete/{id}")
	public TeacherDtoResponse delete(@PathVariable Integer id) {
		return ts.delete(id);
	}
	
	@GetMapping("search/{id}")
	public TeacherDtoResponse search(@PathVariable Integer id) {
		return ts.search(id);
	}
	
	@PostMapping
	public TeacherDtoResponse update(@RequestBody Teacher teacher, @PathVariable Integer id) {
		return ts.update(teacher, id);
	}
	
}
