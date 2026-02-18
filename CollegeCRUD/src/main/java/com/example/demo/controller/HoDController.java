package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HoDDtoRequest;
import com.example.demo.dto.HoDDtoResponse;
import com.example.demo.model.HoD;
import com.example.demo.service.HoDService;

@RestController
@RequestMapping("hod")
public class HoDController {

	@Autowired
	private HoDService hs;
	
	@PostMapping("add")
	public void add(@RequestBody HoDDtoRequest hod) {
		hs.add(hod);
	}
	
	@GetMapping("display")
	public List<HoDDtoResponse> display() {
		return hs.display();
		
	}
	
	@DeleteMapping("delete/{id}")
	public HoDDtoResponse delete(@PathVariable Integer id) {
		return hs.delete(id);
	}
	
	@PutMapping("update/{id}")
	public HoDDtoResponse update(@RequestBody HoD hod, @PathVariable Integer id) {
		return hs.update(hod, id);
	}
}
