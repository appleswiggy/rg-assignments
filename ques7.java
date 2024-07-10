import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private String department;

    // Constructor
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "'}";
    }
}

public class EmployeeJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Create an employee
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setString(3, employee.getDepartment());
            pstmt.executeUpdate();
            System.out.println("Employee added: " + employee);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Read all employees
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
                employees.add(employee);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    // Update an employee
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET name = ?, department = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getDepartment());
            pstmt.setInt(3, employee.getId());
            pstmt.executeUpdate();
            System.out.println("Employee updated: " + employee);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete an employee
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Employee deleted with ID: " + id);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();

        // Create employees
        Employee emp1 = new Employee(1, "John Doe", "HR");
        Employee emp2 = new Employee(2, "Jane Smith", "Finance");
        Employee emp3 = new Employee(3, "Mike Brown", "IT");

        // Add employees
        employeeJDBC.addEmployee(emp1);
        employeeJDBC.addEmployee(emp2);
        employeeJDBC.addEmployee(emp3);

        // Display all employees
        List<Employee> employees = employeeJDBC.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Update an employee
        emp2.setName("Jane Smith Updated");
        emp2.setDepartment("Marketing");
        employeeJDBC.updateEmployee(emp2);

        // Display all employees after update
        employees = employeeJDBC.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Delete an employee
        employeeJDBC.deleteEmployee(1);

        // Display all employees after deletion
        employees = employeeJDBC.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
