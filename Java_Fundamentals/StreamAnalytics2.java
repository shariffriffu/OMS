import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Comparator;

public class StreamAnalytics2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", "IT", 50000.0),
                new Employee("Aisha", "HR", 60000.0),
                new Employee("John", "IT", 70000.0),
                new Employee("Sara", "Finance", 45000.0),
                new Employee("David", "IT", 55000.0));

        List<String> avgSalaryedNameList = employees.stream()
                .filter(employee -> employee.getSalary() > 50000.0)
                .map(employee -> employee.getName())
                .collect(Collectors.toList());

        System.out.println("avgSalaryedNameList " + avgSalaryedNameList);

        double totalSalary = employees.stream()
                .filter(employee -> employee.getSalary() > 50000.0)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("totalSalary " + totalSalary);

        Map<String, Long> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> employee.getDepartment(),
                        Collectors.counting()));
        System.out.println("employeesByDepartment " + employeesByDepartment);

        Map<String, Double> totalSalaryEachDepartment = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(),
                        Collectors.summingDouble(employee -> employee.getSalary())));
        System.out.println("totalSalaryEachDepartment " + totalSalaryEachDepartment);

        Map<String, Double> avrgSalaryEachDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("avrgSalaryEachDepartment " + avrgSalaryEachDepartment);

        Optional<Employee> hightestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        System.out.println("hightestPaid" + hightestPaid);
    }
}

class Employee {
    String name;
    String department;
    double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
}