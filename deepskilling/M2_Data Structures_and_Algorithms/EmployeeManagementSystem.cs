using System;

public class EmployeeManagementSystem
{
    public class Employee
    {
        public string EmployeeId { get; set; }
        public string Name { get; set; }
        public string Position { get; set; }
        public double Salary { get; set; }

        public Employee(string employeeId, string name, string position, double salary)
        {
            EmployeeId = employeeId;
            Name = name;
            Position = position;
            Salary = salary;
        }

        public override string ToString()
        {
            return $"Employee{{id={EmployeeId}, name={Name}, position={Position}, salary={Salary:F2}}}";
        }
    }

    private readonly Employee[] _employees;
    private int _size;

    public EmployeeManagementSystem(int capacity)
    {
        _employees = new Employee[capacity];
        _size = 0;
    }

    public bool AddEmployee(Employee employee)
    {
        if (_size >= _employees.Length)
        {
            return false;
        }
        _employees[_size++] = employee;
        return true;
    }

    public Employee SearchEmployee(string employeeId)
    {
        for (int i = 0; i < _size; i++)
        {
            if (string.Equals(_employees[i].EmployeeId, employeeId, StringComparison.Ordinal))
            {
                return _employees[i];
            }
        }
        return null;
    }

    public void TraverseEmployees()
    {
        if (_size == 0)
        {
            Console.WriteLine("No employees to display.");
            return;
        }
        for (int i = 0; i < _size; i++)
        {
            Console.WriteLine(_employees[i]);
        }
    }

    public bool DeleteEmployee(string employeeId)
    {
        for (int i = 0; i < _size; i++)
        {
            if (string.Equals(_employees[i].EmployeeId, employeeId, StringComparison.Ordinal))
            {
                // Shift elements to the left to fill the gap
                for (int j = i; j < _size - 1; j++)
                {
                    _employees[j] = _employees[j + 1];
                }
                _employees[--_size] = null; // Clear the last reference
                return true;
            }
        }
        return false;
    }

    public static void Main(string[] args)
    {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);
        ems.AddEmployee(new Employee("E001", "Amina", "Manager", 85000));
        ems.AddEmployee(new Employee("E002", "Ben", "Developer", 72000));
        ems.AddEmployee(new Employee("E003", "Clara", "Designer", 68000));

        Console.WriteLine("All employees:");
        ems.TraverseEmployees();

        Console.WriteLine("\nSearch employee E002:");
        Employee searched = ems.SearchEmployee("E002");
        Console.WriteLine(searched != null ? searched.ToString() : "Not Found");

        ems.DeleteEmployee("E001");

        Console.WriteLine("\nAfter deleting E001:");
        ems.TraverseEmployees();
    }
}
