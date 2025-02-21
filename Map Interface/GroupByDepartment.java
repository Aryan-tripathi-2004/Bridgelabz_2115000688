import java.util.*;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee employee : employees) {
            departmentMap.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>()).add(employee);
        }

        return departmentMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> groupedByDepartment = groupEmployeesByDepartment(employees);

        groupedByDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ": " + employeeList);
        });
    }
}
