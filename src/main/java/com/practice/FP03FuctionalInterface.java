package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FP03FuctionalInterface {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);

        // 1. Represents a function that accepts one argument and returns a boolean
        // result
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isEven2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        };

        // filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(isEven)
                .collect(Collectors.toList());

        System.out.println("\nEven numbers: " + evenNumbers);

        // 2. Represents a function that accepts one argument and returns a result
        Function<Integer, Integer> square = n -> n * n;
        Function<Integer, Integer> square2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * n;
            }
        };

        // 3. Represents an operation that accepts a single input argument and returns
        Consumer<Integer> sysoutConsumer = System.out::println;
        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        };

        System.out.println("\nSquares of even numbers (using lambdas):");
        numbers.stream()
                .filter(isEven)
                .map(square)
                .forEach(sysoutConsumer);

        System.out.println("\nSquares of even numbers (using anonymous classes):");
        numbers.stream().filter(isEven2).map(square2).forEach(sysoutConsumer2);

        // 4. represents an operation that accepts two input arguments and returns a
        // result
        BinaryOperator<Integer> sumBinaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        int sumOfEvenNumbers = numbers.stream()
                .reduce(0, sumBinaryOperator);

        System.out.println("\nSum of numbers: " + sumOfEvenNumbers);

        // 5. Represents a supplier of results.
        Supplier<String> randomValueSupplier = () -> Math.random() + "";
        System.out.println("\nRandom value: " + randomValueSupplier.get());

        // 6. Represents an operation that accepts one argument and produces the same
        // result as the input (unary operator)
        UnaryOperator<Integer> squareUnaryOperator = n -> n * n;
        UnaryOperator<Integer> squareUnaryOperator2 = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * n;
            }
        };

        System.out.println("\nSquares of even numbers (using unary operator): ");
        numbers.stream()
                .filter(isEven)
                .map(squareUnaryOperator)
                .forEach(sysoutConsumer);

        System.out.println("\nSquares of even numbers (using unary operator): ");
        numbers.stream()
                .filter(isEven)
                .map(squareUnaryOperator2)
                .forEach(sysoutConsumer);

        // 7. BiPredicate<T, U> - test two values and return boolean result
        BiPredicate<String, Integer> biPredicate = (str, num) -> str.length() > 5 && num < 10;

        System.out.println("\nBiPredicate test result: " + biPredicate.test("Apple", 20));

        // 8. BiConsumer<T, U> - accepts two values and performs an operation (no
        // result)
        BiConsumer<String, Integer> biConsumer = (str, num) -> {
            System.out.println("String: " + str);
            System.out.println("Integer: " + num);
        };

        System.out.println("\nBiConsumer execution:");
        biConsumer.accept("Apple", 20);

        BiFunction<Integer, String, String> biFunction = new BiFunction<Integer, String, String>() {

            @Override
            public String apply(Integer t, String u) {
                return u + " " + t;
            }

        };
        System.out.println("\nBiFunction result: " + biFunction.apply(20, "Apple"));

    }
}
