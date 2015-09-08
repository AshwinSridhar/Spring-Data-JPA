package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.domain.Employee;

public interface CustomRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByEmpName(String empName);
	List<Employee> findByEmpNameOrEmpAge(String empName , Integer empAge);
}
