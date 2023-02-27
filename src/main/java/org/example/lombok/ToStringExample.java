package org.example.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class ToStringExample {
    public static void main(String[] args) {
        toStringMethodTest();
    }

    private static void toStringMethodTest() {
        User user = new User(12, "dilshod", "dilshod@gmail.com", 21);
        System.out.println(user
        );
    }

    @ToString(doNotUseGetters = false, callSuper = true)
    @EqualsAndHashCode(callSuper = true, exclude = {"email", "age"})
    public static class User extends Auditable {
        String username;
        String email;
        int age;

        public User(int id, String username, String email, int age) {
            super(id);
            this.username = username;
            this.email = email;
            this.age = age;
        }

        public String getUsername() {
            System.out.println("Get Username Method");
            return username;
        }

        public String getEmail() {
            System.out.println("Get Email Method");
            return email;
        }

        public int getAge() {
            System.out.println("Get Age Method");
            return age;
        }
    }

    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class Auditable {
        int id;
    }
}

