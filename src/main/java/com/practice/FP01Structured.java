package com.practice;

import java.util.List;

public class FP01Structured {
  private static void printAllNumbers(List<Integer> numbers) {
    for (int num : numbers) {
      System.out.println(num);
    }
  }

  private static void printEvenNumbersInListStructured(List<Integer> numbers) {
    for (int num : numbers) {
      if (num % 2 == 0) {
        System.out.println(num);
      }
    }
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    printAllNumbers(numbers);
    System.out.println("Even numbers in the list:");
    printEvenNumbersInListStructured(numbers);

    System.out.println("============================");
    numbers.stream().forEach(System.out::println);

    System.out.println("Print only even numbers from the list:");
    numbers.stream().filter(num -> num % 2 == 0).forEach(System.out::println);

    System.out.println("Print square of only even numbers from the list:");
    numbers.stream().filter(num -> num % 2 == 0).map(num -> num * num).forEach(System.out::println);

    System.out.println("Sum of all numbers in the list:");
    int sum = numbers.stream().reduce(0, Integer::sum);
    System.out.println(sum);
  }
}
