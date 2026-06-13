package com.practice;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FP04ArraysOperation {

  public static void main(String[] args) {
    int[] numArr = {112, 2, 34, 123, 23, 4, 45, 67, 528};
    System.out.println("Sum of array elements: " + Arrays.stream(numArr).sum());
    System.out.println("Minimum element in array: " + Arrays.stream(numArr).min());
    System.out.println("Maximum element in array: " + Arrays.stream(numArr).max());
    System.out.println("Average of array elements: " + Arrays.stream(numArr).average());
    System.out.println("Sum using reduce: " + Arrays.stream(numArr).reduce(Integer::sum));

    System.out.println("\nSum of range 1 to 9 (exclusive): " + IntStream.range(1, 10).sum());
    System.out.println(
        "Sum of rangeClosed 1 to 10 (inclusive): " + IntStream.rangeClosed(1, 10).sum());

    System.out.println(
        "\nSum of first 10 odd numbers: " + IntStream.iterate(1, x -> x + 2).limit(10).sum());
    System.out.println(
        "\nSum of first 10 powers of 2 (with peek): \n"
            + IntStream.iterate(1, x -> x * 2).limit(10).peek(System.out::println).sum());

    System.out.println("\n" + IntStream.iterate(2, x -> x * 2).limit(10).boxed().toList());

    System.out.println(
        "Product of first 50 numbers: " + IntStream.rangeClosed(1, 50).reduce(1, (x, y) -> x * y));

    System.out.println(
        "Product of first 50 numbers: "
            + LongStream.rangeClosed(1, 50)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply));
  }
}
