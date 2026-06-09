package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FPStringoperation {

    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape");

        // print the words separated by space
        System.out.println(fruits.stream().collect(Collectors.joining(" ")));

        // this will print string object address
        System.out.println(fruits.stream().map(f -> f.split(" ")).collect(Collectors.toList()));

        System.out.println(fruits.stream().map(f -> f.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList()));

    }

}