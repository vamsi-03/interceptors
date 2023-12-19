package com.example.Practice.Repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Practice.Entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Page<Employee> findAll(Pageable pageable);
    
}