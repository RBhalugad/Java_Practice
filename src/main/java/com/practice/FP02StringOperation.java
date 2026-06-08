package com.practice;

import java.util.Comparator;
import java.util.List;

public class FP02StringOperation {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
                "Kubernetes");
        courses.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
        courses.stream().map(String::length).forEach(System.out::println);
        courses.stream().sorted(Comparator.comparingInt(String::length).reversed()).forEach(System.out::println);
    }
}
