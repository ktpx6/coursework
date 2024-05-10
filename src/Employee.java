import java.util.Objects;

public class Employee {
    private static int counter = 1;
    private final int id;
    private final String name;
    private final int salary;
    private final EmployeeBook.Department department;

    public Employee(String name, int salary, EmployeeBook.Department department) {
        this.id = counter++;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public EmployeeBook.Department getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department.getName() +
                '}';
    }
}
