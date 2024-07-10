import java.util.ArrayList;
import java.util.Iterator;
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

public class EmployeeCRUD {
    private List<Employee> employees;

    // Constructor
    public EmployeeCRUD() {
        employees = new ArrayList<>();
    }

    // Create operation
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    // Read operation
    public void displayAllEmployees() {
        System.out.println("Displaying all employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null; // Return null if not found
    }

    // Update operation
    public boolean updateEmployee(int id, String name, String department) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(name);
            employee.setDepartment(department);
            System.out.println("Employee updated: " + employee);
            return true;
        } else {
            System.out.println("Employee not found with ID: " + id);
            return false;
        }
    }

    // Delete operation
    public boolean deleteEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                System.out.println("Employee deleted: " + employee);
                return true;
            }
        }
        System.out.println("Employee not found with ID: " + id);
        return false;
    }

    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();

        // Create employees
        Employee emp1 = new Employee(1, "John Doe", "HR");
        Employee emp2 = new Employee(2, "Jane Smith", "Finance");
        Employee emp3 = new Employee(3, "Mike Brown", "IT");

        // Add employees
        employeeCRUD.addEmployee(emp1);
        employeeCRUD.addEmployee(emp2);
        employeeCRUD.addEmployee(emp3);

        // Display all employees
        employeeCRUD.displayAllEmployees();

        // Update an employee
        employeeCRUD.updateEmployee(2, "Jane Smith", "Marketing");

        // Display all employees after update
        employeeCRUD.displayAllEmployees();

        // Delete an employee
        employeeCRUD.deleteEmployee(1);

        // Display all employees after deletion
        employeeCRUD.displayAllEmployees();
    }
}
