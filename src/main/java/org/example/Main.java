package org.example;

import com.google.gson.reflect.TypeToken;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TypeToken<?> parameterized = TypeToken.getParameterized(List.class, Integer.class);
        System.out.println("Hello world!");
    }


    public static <T> List<T> get(Class<T> clazz) {
        TypeToken<?> parameterized = TypeToken.getParameterized(List.class, clazz);
        return null;
    }
}