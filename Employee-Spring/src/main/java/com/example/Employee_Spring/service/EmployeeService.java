package com.example.Employee_Spring.service;

import com.example.Employee_Spring.dao.EmployeeDao;
import com.example.Employee_Spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    public String createEmployee(Employee employee) {
       return employeeDao.createEmployee(employee);
    }

    public String updateEmployee(Employee employee) {
       return employeeDao.updateEmployee(employee);
    }

    public String deleteEmployee(int id) {
        return employeeDao.deleteEmployee(id);
    }
}