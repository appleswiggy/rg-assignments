package com.example.Employee_Spring.dao;

import com.example.Employee_Spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employees", new EmployeeRowMapper());
    }

    public Employee getEmployeeById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE id = ?", new EmployeeRowMapper(), id);
    }

    public String createEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employees (id, name, department) VALUES (?, ?, ?)", employee.getId(), employee.getName(), employee.getDepartment());
        return "Employee Created Successfully";
    }

    public String updateEmployee(Employee employee) {
        jdbcTemplate.update("UPDATE employees SET name = ?, department = ? WHERE id = ?", employee.getName(), employee.getDepartment(), employee.getId());
        return "Employee Updated Successfully";
    }

    public String deleteEmployee(int id) {
        jdbcTemplate.update("DELETE FROM employees WHERE id = ?", id);
        return "Employee Deleted Successfully";
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setDepartment(rs.getString("department"));
            return employee;
        }
    }
}