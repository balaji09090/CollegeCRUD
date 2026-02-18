package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.HoDDtoRequest;
import com.example.demo.dto.HoDDtoResponse;
import com.example.demo.model.HoD;

public interface HoDService {

	void add(HoDDtoRequest hod);
	
	List<HoDDtoResponse> display();
	
	HoDDtoResponse delete(Integer id);
	
	HoDDtoResponse update(HoD hod, Integer id);
	
	HoDDtoResponse search(Integer id);
	
	
	
	
}
