package Streams.TerminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TermOperations1 {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 3, 4, 6, 2, 8, 9);
        List<String> list1 = Arrays.asList("rohit", "Virat", "pant", "sky");

        //reduce will produce the one result from the list
        int sum=list.stream().
                reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        //collect will collect the elements
        List<Integer> squareList=list.stream()
                .filter(n->n%2==0)
                .map(n->n*n)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(squareList);

        //grouping by is going to group by the single value
        System.out.println("-------------Group by function----------");
        List<Employee> employeeList=Arrays.asList(
                new Employee("Rohit","IT",90000),
                new Employee("Pant","Mech",40000),
                new Employee("Virat","IT",80000),
                new Employee("Bumrah","ECE",70000),
                new Employee("SKY","IT",45000),
                new Employee("Jadeja","Mech",30000));

        Map<String,List<Employee>> employeeByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
        //System.out.println(employeeByDepartment);
        //Print the group by map
        employeeByDepartment.forEach((department,employees)-> {
            System.out.println("Department " + department);
            employees.stream().forEach(System.out::println);
        });

        //Partition by is going to the partition the list based on condition
        System.out.println("------------Partition by function---------");
        Map<Boolean,List<Employee>> employeeBySalary=
                employeeList.stream()
                        .collect(Collectors.partitioningBy(employee -> employee.getSalary()>50000));

        //System.out.println(employeeBySalary);
        System.out.println("Employee salary above 50000 : ");
        employeeBySalary.get(true).forEach(System.out::println);

        System.out.println("Employee salary below 50000 : ");
        employeeBySalary.get(false).forEach(System.out::println);

    }
}
