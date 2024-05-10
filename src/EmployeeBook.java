import java.util.ArrayList;
import java.util.List;

public class EmployeeBook {
    private final List<Employee> employees;

    public EmployeeBook() {
        employees = new ArrayList<>();
    }

    public void addEmployee(String name, int salary, Department department) {
        for (Employee emp : employees) {
            if (emp.getName().equals(name)) {
                return;
            }
        }
        employees.add(new Employee(name, salary, department));
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                break;
            }
        }
    }

    public Employee findEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public double getTotalSalaryExpense() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.getSalary();
        }
        return total;
    }

    public Employee getEmployeeWithMinSalary() {
        if (employees.isEmpty()) {
            return null;
        }
        Employee minSalaryEmployee = employees.get(0);
        for (Employee emp : employees) {
            if (emp.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = emp;
            }
        }
        return minSalaryEmployee;
    }

    public Employee getEmployeeWithMaxSalary() {
        if (employees.isEmpty()) {
            return null;
        }
        Employee maxSalaryEmployee = employees.get(0);
        for (Employee emp : employees) {
            if (emp.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = emp;
            }
        }
        return maxSalaryEmployee;
    }

    public double getAverageSalary() {
        if (employees.isEmpty()) {
            return 0;
        }
        double totalSalary = getTotalSalaryExpense();
        return totalSalary / employees.size();
    }

    public Department getDepartmentWithMaxAverageSalary() {
        if (employees.isEmpty()) {
            return null;
        }
        Department maxAverageSalaryDepartment = null;
        double maxAverageSalary = 0;
        for (Employee employee : employees) {
            Department department = employee.getDepartment();
            double averageSalary = calculateAverageSalaryForDepartment(department);
            if (averageSalary > maxAverageSalary) {
                maxAverageSalary = averageSalary;
                maxAverageSalaryDepartment = department;
            }
        }
        return maxAverageSalaryDepartment;
    }

    private double calculateAverageSalaryForDepartment(Department department) {
        double totalSalary = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                totalSalary += employee.getSalary();
                count++;
            }
        }
        return totalSalary / count;
    }

    public static class Department {
        private final int id;
        private final String name;

        public Department(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
