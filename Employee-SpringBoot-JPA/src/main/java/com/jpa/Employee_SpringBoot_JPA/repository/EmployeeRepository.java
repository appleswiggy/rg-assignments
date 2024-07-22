package com.jpa.Employee_SpringBoot_JPA.repository;

import com.jpa.Employee_SpringBoot_JPA.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}