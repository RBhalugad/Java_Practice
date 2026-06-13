package com.practice;

import java.util.Comparator;
import java.util.List;

public class FP02operation {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(112, 2, 34, 123, 23, 4, 45, 67, 528);

    System.out.println("Max Value:");
    numbers.stream().max(Integer::compare).ifPresent(System.out::println);

    System.out.println("\nMin Value:");
    numbers.stream().min(Integer::compare).ifPresent(System.out::println);

    System.out.println("\nSquare Sum:");
    int squareSum = numbers.stream().map(num -> num * num).reduce(0, Integer::sum);
    System.out.println(squareSum);

    System.out.println("\nCube Sum:");
    int cubeSum = numbers.stream().map(num -> num * num * num).reduce(0, Integer::sum);
    System.out.println(cubeSum);

    System.out.println("\nSquare Sum of Even Numbers:");
    int evenSquareSum =
        numbers.stream().filter(num -> num % 2 == 0).map(num -> num * num).reduce(0, Integer::sum);
    System.out.println(evenSquareSum);

    System.out.println("\nSorted Elements:");
    numbers.stream().sorted().forEach(System.out::println);

    System.out.println("\nSorted in Descending Order:");
    numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

    System.out.println("\nDistinct Elements:");
    numbers.stream().distinct().forEach(System.out::println);
  }
}
