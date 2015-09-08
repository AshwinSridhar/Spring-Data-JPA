package com.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	CustomRepository customRepository;
	
	public void insertEmpoloyee(){
		Employee emp = new Employee();
		emp.setEmpAge(100);
		emp.setEmpId(1);
		emp.setEmpName("Ashwin");
		emp.setEmpLastName("Sridhar");
		customRepository.save(emp);
		
	}
	
	public void readEmployee(){
		//List<Employee> e = customRepository.findByEmpName("Ashwin");
		
		List<Employee> e = customRepository.findByEmpNameOrEmpAge("Ramya", 10);
		
		for( Employee emp : e){
			
			System.out.println(emp.getEmpAge());
			System.out.println(emp.getEmpLastName());
			
			emp.setEmpAge(new Integer(100));
			
			customRepository.save(emp);
			
		}
		
		List<Employee> e1 = customRepository.findByEmpNameOrEmpAge("Ramya", 100);
		
for( Employee emp : e1){
			
			System.out.println(emp.getEmpAge());
			System.out.println(emp.getEmpLastName());
			
		}
		
	}
	
}
