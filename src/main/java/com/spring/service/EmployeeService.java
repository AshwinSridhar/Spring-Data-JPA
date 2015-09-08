package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void insertEmployee(){
		System.out.println("About to insert..");
		employeeRepository.insertEmpoloyee();
	}
	
	public void readEmployee(){
		employeeRepository.readEmployee();
	}
}
