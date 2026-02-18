package com.example.demo.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.InvalidDept;
import com.example.demo.exception.InvalidDivision;
import com.example.demo.exception.InvalidEmail;
import com.example.demo.exception.InvalidExp;
import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvalidMobileNumber;
import com.example.demo.exception.InvalidName;
import com.example.demo.exception.InvalidPassword;
import com.example.demo.exception.InvalidRoll;
import com.example.demo.exception.InvalidYear;
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidMobileNumber.class)
	public ResponseEntity<?> InvalidMobileNumber(InvalidMobileNumber e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<?>InvalidId(InvalidId e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidName.class)
	public ResponseEntity<?>InvalidName(InvalidName e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidEmail.class)
	public ResponseEntity<?>InvalidEmail(InvalidEmail e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidRoll.class)
	public ResponseEntity<?>InvalidRoll(InvalidRoll e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidDivision.class)
	public ResponseEntity<?>InvalidDivision(InvalidDivision e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidYear.class)
	public ResponseEntity<?>InvalidYear(InvalidYear e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidExp.class)
	public ResponseEntity<?> handleInvalidExp(InvalidExp e) {
	    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidDept.class)
	public ResponseEntity<?> handleInvalidExp(InvalidDept e) {
	    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidPassword.class)
	public ResponseEntity<?> handleInvalidExp(InvalidPassword e) {
	    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
}
