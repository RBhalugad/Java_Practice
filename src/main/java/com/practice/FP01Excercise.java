package com.practice;

import java.util.List;

public class FP01Excercise {
  public static void main(String[] args) {
    List<String> courses =
        List.of(
            "Spring",
            "Spring Boot",
            "API",
            "Microservices",
            "AWS",
            "PCF",
            "Azure",
            "Docker",
            "Kubernetes");
    courses.stream().forEach(System.out::println);

    System.out.println("Courses containing the word Spring:");
    courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);

    System.out.println("Courses with at least 4 characters:");
    courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);

    System.out.println("Courses with 'Spring' at the beginning:");
    courses.stream().filter(course -> course.startsWith("Spring")).forEach(System.out::println);

    System.out.println("Print all courses sorted by length in natural order:");
    courses.stream().sorted().forEach(System.out::println);

    System.out.println("Print all courses length:");
    courses.stream().map(String::length).forEach(System.out::println);
  }
}
