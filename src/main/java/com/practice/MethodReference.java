package com.practice;

import java.util.List;
import java.util.function.Supplier;

public class MethodReference {

  private static void print(String str) {
    System.out.println(str);
  }

  public static void main(String[] args) {
    List<String> courses = List.of("Java", "Spring", "AWS", "React", "Springboot", "API");
    courses.stream().map(String::toUpperCase).forEach(MethodReference::print);

    Supplier<String> dSupplier = String::new;
    dSupplier.get();
  }
}
