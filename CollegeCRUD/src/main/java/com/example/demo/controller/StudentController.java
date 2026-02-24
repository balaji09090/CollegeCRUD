package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDtoRequest;
import com.example.demo.dto.StudentDtoResponse;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService ss;
	
	@PostMapping("add")
	public void add(@RequestBody StudentDtoRequest student) {
		ss.add(student);
	}
	
	@GetMapping("display")
	public List<StudentDtoResponse> display() {
		return ss.display();
		
	}
	
	@DeleteMapping("delete/{roll}")
	public StudentDtoResponse delete(@PathVariable Integer roll) {
		return ss.delete(roll);
	}
		
	@PutMapping("update/{roll}")
	public StudentDtoResponse update(@RequestBody Student student, @PathVariable Integer roll) {
		return ss.update(student, roll);
	}
	
	@GetMapping("search/{roll}")
	public StudentDtoResponse search(@PathVariable Integer roll) {
		return ss.search(roll);
	}
	
}
