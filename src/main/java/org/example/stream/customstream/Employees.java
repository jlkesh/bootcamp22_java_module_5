package org.example.stream.customstream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.behpar.BehParExample;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Employees {
    private List<Employee> emps = new ArrayList<>();


    public Employees() {
        emps.add(new Employee("Javohir", "UZ", "MANAGER", 18));
        emps.add(new Employee("ProDino", "US", "JUNIOR_DEV", 19));
        emps.add(new Employee("Baxtigul", "FR", "MANAGER", 22));
        emps.add(new Employee("Nodir", "UZ", "JUNIOR", 22));
        emps.add(new Employee("Uktam", "US", "DEVELOPER", 18));
    }

    @AllArgsConstructor
    @Data
    public static class Employee {
        private String name;
        private String country;
        private String position;
        private int age;
    }

    public Stream<Employee> stream() {
        Spliterator<Employee> spliterator = Spliterators.spliterator(emps, Spliterator.CONCURRENT);
        return StreamSupport.stream(spliterator, true);
    }

    public static void main(String[] args) {
        Employees employees = new Employees();
        Stream<Employee> stream = employees.stream();
        Stream<String> stringStream = stream
                .map(Employee::getName)
                .map(String::toUpperCase);

        stringStream.forEach(System.out::println);
    }
}
