		package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TeacherDtoRequest;
import com.example.demo.dto.TeacherDtoResponse;
import com.example.demo.exception.InvalidEmail;
import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvalidMobileNumber;
import com.example.demo.exception.InvalidName;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository tr;

    @Override
    public void add(TeacherDtoRequest teacher) {
//    	id
    	int id = teacher.getId();
    	if(id>0) {
    		if(tr.existsById(id)) {
    			throw new InvalidId("Id Already Exixts");	
    		}
    	}
    	
//    	name
    	String name = teacher.getName();
//    	if(tr.existsByName(name)) {
//    		throw new InvalidName("Name Already Exists");
//    	}
    	if(!teacher.getName().matches("[a-zA-Z ]+")) { 
    	    throw new InvalidName("Name should contain only letters"); 
    	}
    	
//    	mob
    	String mob = teacher.getMob();
    	if(tr.existsByMob(mob)) {
    		throw new InvalidMobileNumber("Mobile Number Already Exists");
    	}
    	if(mob.length() == 10) {
    		if(mob.charAt(0) == '0' || mob.charAt(0) == '1' || mob.charAt(0) == '2' || mob.charAt(0) == '3' || mob.charAt(0) == '4' || mob.charAt(0) == '5')
    			throw new InvalidMobileNumber("Invalid Mobile Number");
    		
    		for (int i=0; i < mob.length(); i++) {
    			if(!Character.isDigit(mob.charAt(i)))
    				throw new InvalidMobileNumber("Invalid Mobile Number");
    		}
    	}else
    		throw new InvalidMobileNumber("Invalid Mobile Number");
    		
    	
//    	email
    	String email = teacher.getEmail();
    	if(tr.existsByEmail(email)) {
    		throw new InvalidEmail("Email Already Exist");
    	}
    	if (teacher.getEmail() == null || teacher.getEmail().isEmpty()) {
    		throw new InvalidEmail("Email  cannot be Empty or Null");
    	}
    	if (!teacher.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
    	    throw new InvalidEmail("Invalid email format");
    	}

    	
    	Teacher t = TeacherDtoRequest.toEntity(teacher);
    	tr.save(t);
    	
    	
    	
    }

    @Override
    public List<TeacherDtoResponse> display() {
    	List<Teacher> teacher=tr.findAll();
        return teacher.stream().map(TeacherDtoResponse::toDto).toList();
    }

    @Override
    public TeacherDtoResponse delete(Integer id) {

        if (id == null || id <= 0) {
            throw new InvalidId("Invalid ID");
        }

        if (tr.findById(id).isPresent()) {
            Teacher temp = tr.findById(id).get();
            tr.deleteById(id);
            return TeacherDtoResponse.toDto(temp);
        }
        return null;
    }

    @Override
    public TeacherDtoResponse update(Teacher teacher, Integer id) {

        if (tr.findById(id).isPresent()) {
           Teacher temp = tr.findById(id).get();
           temp.setName(teacher.getName());
           temp.setMob(teacher.getMob());
           temp.setEmail(teacher.getEmail());
           temp.setPassword(teacher.getPassword());
           
           Teacher t = tr.save(temp);
           return TeacherDtoResponse.toDto(t);
        }
		return null;
           
    }

    @Override
    public TeacherDtoResponse search(Integer id) {
    	if (tr.findById(id).isPresent()) {
            Teacher temp = tr.findById(id).get();
            return TeacherDtoResponse.toDto(temp);
        }
        return null;
    }

    @Override
    public void addAll(List<Teacher> list) {
        tr.saveAll(list);
    }

    
}
