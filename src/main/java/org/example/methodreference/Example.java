package org.example.methodreference;

import java.util.UUID;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        Employee employee = new Employee("Xikmatjon");

        Stream.of("John", "Jl", "ProDino")
                //.map(Employee::toEmp)
                //.map(String::length)
                .map(Employee::new);
        //.forEach(employee::setName);
    }

    public static class Employee {
        private String id;
        private String name;

        public Employee(String name) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static Employee toEmp(String name) {
            return new Employee(name);
        }


    }
}
