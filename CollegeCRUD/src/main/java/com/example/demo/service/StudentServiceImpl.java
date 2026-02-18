package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDtoRequest;
import com.example.demo.dto.StudentDtoResponse;
import com.example.demo.exception.InvalidDivision;
import com.example.demo.exception.InvalidEmail;
import com.example.demo.exception.InvalidName;
import com.example.demo.exception.InvalidPassword;
import com.example.demo.exception.InvalidRoll;
import com.example.demo.exception.InvalidYear;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository sr;
	private Student student;
	
	@Override
	public void add(StudentDtoRequest student) {
		// TODO Auto-generated method stub
		
//		roll
		int roll = student.getRoll();
		if(student.getRoll() == null) {
			throw new InvalidRoll("Roll Cannot be Null");
		}
		
		if(student.getRoll() <= 0) {
			throw new InvalidRoll("Roll number cannot be 0");
		}
		
		if(sr.existsByRoll(roll)) {
			throw new InvalidRoll("Roll Number Already Exists");
		}
		
//		name
		String name = student.getName();
//		if(sr.existsByName(name)) {
//			throw new InvalidName("Name Already Exists");
//		}
		if(!student.getName().matches("[a-zA-Z ]+")) { 
		    throw new InvalidName("Name should contain only letters"); 
		}
		
//	division
		String division = student.getDivision().trim();
		if (student.getDivision() == null || student.getDivision().isEmpty()) {
			throw new InvalidDivision("Division cannot be Null or Empty");
		}
		
		if (!(division.equalsIgnoreCase("A") || division.equalsIgnoreCase("B") || division.equalsIgnoreCase("C"))) {
			throw new InvalidDivision("Only select Division A,B,C");
		}
		
//		year
		if(student.getYear() == null) {
			throw new InvalidYear("Year Cannot Be Null");
		}
		if(student.getYear() < 1 || student.getYear() > 4) {
			throw new InvalidYear("Year Must Be Between 1 and 4");
		}
		
//		email
		String email = student.getEmail();
		if(student.getEmail() == null || student.getEmail().isEmpty()) {
			throw new InvalidEmail("Email cannot be Null or Empty");
		}
		if (!student.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
		    throw new InvalidEmail("Invalid email format");

	    }
		if (sr.existsByEmail(student.getEmail())) {
	        throw new InvalidEmail("Email Already Exists");
	    }
		
//		password
		String password = student.getPassword().trim();
		if (!sr.existsByPassword(password)) {
			if (!(password.length() >= 6)) {
				throw new InvalidPassword("Password more than six letters");
			}
			for (int i = 0; i < password.length(); i++) {
//				if (!(password.charAt(i) == '@' || password.charAt(i) == '#' || password.charAt(i) == '$'
//						|| password.charAt(i) == '&' || password.charAt(i) == '*')) {
//					throw new InvalidPassword("At least one special symbole");
//
//				}
//				if (!(password.charAt(i) == '0' || password.charAt(i) == '1' || password.charAt(i) == '2'
//						|| password.charAt(i) == '2' || password.charAt(i) == '3' || password.charAt(i) == '4'
//						|| password.charAt(i) == '5' || password.charAt(i) == '6' || password.charAt(i) == '7'
//						|| password.charAt(i) == '8' || password.charAt(i) == '9')) {
//					throw new InvalidPassword("At least one number allowed");
//
//				}

			}

		} else
			throw new InvalidPassword(" Password Is Alreday exits");
		
		Student s = StudentDtoRequest.toEntity(student);
		sr.save(s);
	}

	@Override
	public List<StudentDtoResponse> display() {
		// TODO Auto-generated method stub
		List<Student> student = sr.findAll();
		return student.stream().map(StudentDtoResponse::toDto).toList();
	}

	@Override
	public StudentDtoResponse delete(Integer roll) {
		// TODO Auto-generated method stub
		if (sr.findById(roll).isPresent()) {
			Student temp = sr.findById(roll).get();
			sr.deleteById(roll);
			return StudentDtoResponse.toDto(temp);
		}
		return null;
	}

	@Override
	public StudentDtoResponse update(Student student, Integer roll) {
		// TODO Auto-generated method stub
		if(sr.findById(roll).isPresent()) {
			Student temp = sr.findById(roll).get();
			temp.setName(student.getName());
			temp.setEmail(student.getEmail());
			temp.setDivision(student.getDivision());
			temp.setMarks(student.getMarks());
			temp.setYear(student.getYear());
			temp.setPassword(student.getPassword());
			
			Student ss = sr.save(temp);
			
			return StudentDtoResponse.toDto(ss);
		}
		return null;
	}

	@Override
	public StudentDtoResponse search(Integer roll) {
		// TODO Auto-generated method stub
		if (sr.findById(roll).isPresent()) {
			Student temp = sr.findById(roll).get();
			return StudentDtoResponse.toDto(temp);
		}
		return null;
	}

	@Override
	public void addAll(List<Student> list) {
		// TODO Auto-generated method stub
		
	}

}
