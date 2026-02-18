package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CollegeCrudApplication;
import com.example.demo.dto.HoDDtoRequest;
import com.example.demo.dto.HoDDtoResponse;
import com.example.demo.exception.InvalidDept;
import com.example.demo.exception.InvalidEmail;
import com.example.demo.exception.InvalidExp;
import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvalidMobileNumber;
import com.example.demo.exception.InvalidName;
import com.example.demo.model.HoD;
import com.example.demo.repository.HoDRepository;

@Service
public class HoDServiceImpl implements HoDService{

    private final CollegeCrudApplication collegeCrudApplication;
	
	@Autowired
	private HoDRepository hr;
	private HoD hod;

    HoDServiceImpl(CollegeCrudApplication collegeCrudApplication) {
        this.collegeCrudApplication = collegeCrudApplication;
    }
	
	@Override
	public void add(HoDDtoRequest hod) {
		// TODO Auto-generated method stub
		
//		id
		int id = hod.getId();
		if(hod.getId() == null || hod.getId() <= 0) {
			throw new InvalidId("Invalid HOD Id");
		}
		if (hr.existsById(id)) {
			throw new InvalidId ("HOD Id Already Exists");
		}
		
//		name
		String name = hod.getName();
//		if(hr.existsById(id)) {
//			throw new InvalidName ("Name ")
//		}
		if(!hod.getName().matches("[a-zA-Z. ]+")) {
		    throw new InvalidName("Name should contain only letters");
		}

		
//		exp
		Float exp = hod.getExp();
		
		if(hod.getExp() == null){
		    throw new InvalidExp("Experience cannot be null");
		}
		if(hod.getExp() < 5){
		    throw new InvalidExp("HoD must have minimum 5 years experience");
		}
		
//		mob
		String mob = hod.getMob();
		
		// Null check
		if(mob == null) {
		    throw new InvalidMobileNumber("Mobile Number Cannot Be Null");
		}

		// Length check
		if(mob.length() != 10) {
		    throw new InvalidMobileNumber("Mobile Number Must Be 10 Digits");
		}

		// First digit check (Indian number)
		if(mob.charAt(0) < '6') {
		    throw new InvalidMobileNumber("Invalid Mobile Number");
		}

		// Digit check
		for(int i = 0; i < mob.length(); i++) {
		    if(!Character.isDigit(mob.charAt(i))) {
		        throw new InvalidMobileNumber("Mobile Number Must Contain Only Digits");
		    }
		}

		// Exists check (keep at last)
		if(hr.existsByMob(mob)) {
		    throw new InvalidMobileNumber("Mobile Number Already Exists");
		}

		
//		email
		String email = hod.getEmail();
		
		if(hr.existsByEmail(email)) { 
    		throw new InvalidEmail("Email Already Exist");
    	}
    	if (hod.getEmail() == null || hod.getEmail().isEmpty()) { 
    		throw new InvalidEmail("Email  cannot be Empty or Null");
    	}
    	if (!hod.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
    	    throw new InvalidEmail("Invalid email format");
    	}

    	
//    	dept
    	String dept = hod.getDept();
    	
    	if (hod.getDept() == null || hod.getDept().trim().isEmpty()) {
    	    throw new InvalidDept("Invalid Department");
    	}

    	if (!hod.getDept().matches("[A-Za-z ]+")) {
    	    throw new InvalidDept("Department must contain only letters");
    	}

		
		
		HoD h = HoDDtoRequest.toEntity(hod); 
		hr.save(h);
		}
	

	@Override
	public List<HoDDtoResponse> display() {
		// TODO Auto-generated method stub
		List<HoD> hod = hr.findAll();
		return hod.stream().map(HoDDtoResponse::toDto).toList();
	}

	@Override
	public HoDDtoResponse delete(Integer id) {
		// TODO Auto-generated method stub
		if (hr.findById(id).isPresent()) {
			HoD temp = hr.findById(id).get();
			hr.deleteById(id);
			return HoDDtoResponse.toDto(temp);
		}
		
		return null;
	}

	@Override
	public HoDDtoResponse update(HoD hod, Integer id) {
		// TODO Auto-generated method stub
		if (hr.findById(id).isPresent()) {
			HoD temp = hr.findById(id).get();
			temp.setName(hod.getName());
			temp.setDept(hod.getDept());
			temp.setEmail(hod.getEmail());
			temp.setExp(hod.getExp());
			temp.setPassword(hod.getPassword());
			
			HoD h = hr.save(temp);
			return HoDDtoResponse.toDto(h);
		}
		return null;
	}

	@Override
	public HoDDtoResponse search(Integer id) {
		// TODO Auto-generated method stub
		if(hr.findById(id).isPresent()) {
			HoD temp = hr.findById(id).get();
			return HoDDtoResponse.toDto(temp);
		}
		return null;
	}

	

}
