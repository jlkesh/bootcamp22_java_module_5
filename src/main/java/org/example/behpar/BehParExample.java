package org.example.behpar;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class BehParExample {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Javohir", "UZ", "MANAGER", 18);
        Employee emp2 = new Employee("ProDino", "US", "JUNIOR_DEV", 19);
        Employee emp3 = new Employee("Baxtigul", "FR", "MANAGER", 22);
        Employee emp4 = new Employee("Nodir", "UZ", "JUNIOR", 22);
        Employee emp5 = new Employee("Uktam", "US", "DEVELOPER", 18);

        List<Employee> employees = List.of(emp1, emp2, emp3, emp4, emp5);
        System.out.println(findEmps(employees, e -> e.getCountry().equalsIgnoreCase("uz")));
        System.out.println(findEmps(employees, e -> e.getCountry().equalsIgnoreCase("fr")));
        System.out.println(findEmps(employees, e -> e.getAge() == 22));
        System.out.println(findEmps(employees, e -> e.getAge() >= 19));

        int a = 90;
        final int dd = a;
        Runnable runnable = () -> {
            System.out.println(dd);
        };
        a = 88;


    }

    private static Predicate<Employee> get() {
        return (e) -> e.getCountry().equalsIgnoreCase("UZ");
    }

    private static List<Employee> findUzEmps(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getCountry().equals("UZ")) {
                emps.add(employee);
            }
        }
        return emps;
    }

    private static List<Employee> findFREmps(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getCountry().equals("FR")) {
                emps.add(employee);
            }
        }
        return emps;
    }

    private static List<Employee> findEmps(List<Employee> employees, Predicate<Employee> filter) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if (filter.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }


    @AllArgsConstructor
    @Data
    public static class Employee {
        private String name;
        private String country;
        private String position;
        private int age;
    }
}

@FunctionalInterface
interface EmployeeFilter {
    boolean test(BehParExample.Employee employee);
}

/*
class EmployeeFilterByAge implements EmployeeFilter {
    private final int age;

    EmployeeFilterByAge(int age) {
        this.age = age;
    }

    @Override
    public boolean test(BehParExample.Employee employee) {
        return employee.getAge() == age;
    }
}


class EmployeeFilterByCountry implements EmployeeFilter {
    private final String country;

    EmployeeFilterByCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean test(BehParExample.Employee employee) {
        return employee.getCountry().equals(country);
    }
}


*/
