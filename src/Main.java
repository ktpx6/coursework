import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        EmployeeBook.Department salesDepartment = new EmployeeBook.Department(1, "Отдел продаж");
        EmployeeBook.Department marketingDepartment = new EmployeeBook.Department(2, "Отдел маркетинга");
        EmployeeBook.Department developmentDepartment = new EmployeeBook.Department(3, "Отдел разработки");

        employeeBook.addEmployee("Ли Мольдавер", 145_000, salesDepartment);
        employeeBook.addEmployee("Ягами Лайт", 160_000, marketingDepartment);
        employeeBook.addEmployee("Рукия Кучики", 180_000, developmentDepartment);

        System.out.println();
        System.out.println("Все работники:");
        List<Employee> allEmployees = employeeBook.getAllEmployees();
        for (Employee emp : allEmployees) {
            System.out.println(emp.getName() + " - " + emp.getSalary() + " - " + emp.getDepartment().getName());
        }

        System.out.println();
        System.out.println("Общие расходы на заработную плату: " + employeeBook.getTotalSalaryExpense());

        System.out.println();
        Employee minSalaryEmployee = employeeBook.getEmployeeWithMinSalary();
        if (minSalaryEmployee != null) {
            System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee.getName() + " - " + minSalaryEmployee.getSalary() + " - " + minSalaryEmployee.getDepartment().getName());
        } else {
            System.out.println("Нет сотрудников");
        }

        System.out.println();
        Employee maxSalaryEmployee = employeeBook.getEmployeeWithMaxSalary();
        if (maxSalaryEmployee != null) {
            System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee.getName() + " - " + maxSalaryEmployee.getSalary() + " - " + maxSalaryEmployee.getDepartment().getName());
        } else {
            System.out.println("Нет сотрудников");
        }

        System.out.println();
        System.out.println("Средняя зарплата: " + employeeBook.getAverageSalary());

        System.out.println();
        EmployeeBook.Department departmentWithMaxAverageSalary = employeeBook.getDepartmentWithMaxAverageSalary();
        if (departmentWithMaxAverageSalary != null) {
            System.out.println("Отдел с максимальной средней зарплатой: " + departmentWithMaxAverageSalary.getName());
        } else {
            System.out.println("Нет отделов");
        }
    }
}
