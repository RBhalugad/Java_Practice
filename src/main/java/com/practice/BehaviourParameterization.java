package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaviourParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);

        System.out.println("Multiples of 3:");
        filterAndPrint(numbers, x -> x % 3 == 0);

        List<Integer> squareIntegers = mapAndCreateNewList(numbers, x -> x * x);
        System.out.println("\nSquared numbers: " + squareIntegers);

        List<Integer> cubeIntegers = mapAndCreateNewList(numbers, x -> x * x * x);
        System.out.println("\nCubed numbers: " + cubeIntegers);

        List<Integer> doubleNumbers = mapAndCreateNewList(numbers, x -> x * 2);
        System.out.println("\nDoubled numbers: " + doubleNumbers);

    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream().filter(predicate).forEach(x -> System.out.println(x));
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> function) {
        return numbers.stream().map(function).collect(Collectors.toList());
    }
}
