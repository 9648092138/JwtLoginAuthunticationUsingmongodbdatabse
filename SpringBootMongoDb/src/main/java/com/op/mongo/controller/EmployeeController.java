package com.op.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.op.mongo.entity.Employee;
import com.op.mongo.entity.Tutorial;
import com.op.mongo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeerepository;
	
	@PostMapping("/employee")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Employee> createUser(@RequestBody Employee tutorial) {
	  try {
		  Employee emp = new Employee();
		  emp.setName(tutorial.getName());
		  emp.setDesignation(tutorial.getDesignation());
		  Employee _tutorial = employeerepository.save(emp);
	    return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	  }
	}
}
