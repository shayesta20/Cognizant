import java.util.Arrays;

public class EmployeeManagementSystem {
    static class Employee {
        String employeeId;
        String name;
        String position;
        double salary;

        Employee(String employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("Employee{id=%s, name=%s, position=%s, salary=%.2f}",
                    employeeId, name, position, salary);
        }
    }

    private final Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            return false;
        }
        employees[size++] = employee;
        return true;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId.equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId.equals(employeeId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        ems.addEmployee(new Employee("E001", "Amina", "Manager", 85000));
        ems.addEmployee(new Employee("E002", "Ben", "Developer", 72000));
        ems.addEmployee(new Employee("E003", "Clara", "Designer", 68000));

        System.out.println("All employees:");
        ems.traverseEmployees();

        System.out.println("\nSearch employee E002:");
        System.out.println(ems.searchEmployee("E002"));

        ems.deleteEmployee("E001");
        System.out.println("\nAfter deleting E001:");
        ems.traverseEmployees();
    }
}
