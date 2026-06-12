package com.practice;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04CustomClass {

        public static void main(String[] args) {
                List<Courses> courses = List.of(
                                new Courses("Spring", "Framework", 99, 10000),
                                new Courses("React", "Library", 98, 9000),
                                new Courses("Java", "Language", 97, 8000),
                                new Courses("Docker", "Platform", 96, 7000),
                                new Courses("Kubernetes", "Platform", 95, 6000),
                                new Courses("AWS", "Cloud", 94, 5000),
                                new Courses("Azure", "Cloud", 93, 4000),
                                new Courses("GCP", "Cloud", 92, 3000),
                                new Courses("Microservices", "Architecture", 91, 2000),
                                new Courses("Serverless", "Architecture", 90, 1000));

                // 1. allMatch, nonMatch, anyMatch
                Predicate<Courses> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;

                Predicate<Courses> reviewScoreLessThan90 = course -> course.getReviewScore() < 90;

                System.out.println(
                                "Do all courses have a review score > 95? : "
                                                + courses.stream().allMatch(reviewScoreGreaterThan95));
                System.out.println(
                                "Do no courses have a review score > 95?  : "
                                                + courses.stream().noneMatch(reviewScoreGreaterThan95));
                System.out.println(
                                "Do any courses have a review score > 95? : "
                                                + courses.stream().anyMatch(reviewScoreGreaterThan95));

                System.out.println(
                                "\nDo all courses have a review score < 90? : "
                                                + courses.stream().allMatch(reviewScoreLessThan90));
                System.out.println(
                                "Do no courses have a review score < 90?  : "
                                                + courses.stream().noneMatch(reviewScoreLessThan90));
                System.out.println(
                                "Do any courses have a review score < 90? : "
                                                + courses.stream().anyMatch(reviewScoreLessThan90));

                // 2.
                Comparator<Courses> compareByNoOfStudents = Comparator.comparingInt(Courses::getNoOfStudents);

                List<Courses> sortedCourses = courses.stream().sorted(compareByNoOfStudents).toList();
                System.out.println("\nCourses sorted by number of students:");
                sortedCourses.forEach(System.out::println);

                Comparator<Courses> compareByNoOfStudentsDescending = Comparator.comparingInt(Courses::getNoOfStudents)
                                .reversed();

                List<Courses> sortedCoursesDescending = courses.stream().sorted(compareByNoOfStudentsDescending)
                                .toList();
                System.out.println("\nCourses sorted by number of students descending:");
                sortedCoursesDescending.forEach(System.out::println);

                // 3 . sorted by review score and then no of students
                Comparator<Courses> compareByReviewScoreAndNoOfStudents = Comparator
                                .comparingInt(Courses::getReviewScore)
                                .thenComparingInt(Courses::getNoOfStudents);

                List<Courses> sortedCoursesAndReviewScore = courses.stream().sorted(compareByReviewScoreAndNoOfStudents)
                                .toList();
                System.out.println("\nCourses sorted by review score and then number of students:");
                sortedCoursesAndReviewScore.forEach(System.out::println);

                // limiting the List to print only the desired nos
                List<Courses> sortedCoursesAndReviewScoreLimit = courses.stream()
                                .sorted(compareByReviewScoreAndNoOfStudents).limit(3)
                                .toList();
                System.out.println("\nCourses sorted by review score and then number of students (limited to 3):");
                sortedCoursesAndReviewScoreLimit.forEach(System.out::println);

                // skipping the first few nos
                List<Courses> sortedCoursesAndReviewScoreSkip = courses.stream()
                                .sorted(compareByReviewScoreAndNoOfStudents).skip(3)
                                .toList();
                System.out.println("\nCourses sorted by review score and then number of students (skip first 3):");
                sortedCoursesAndReviewScoreSkip.forEach(System.out::println);

                // Skipping and limiting
                List<Courses> sortedCoursesAndReviewScoreSkipLimit = courses.stream()
                                .sorted(compareByReviewScoreAndNoOfStudents).skip(3).limit(5)
                                .toList();
                System.out.println(
                                "\nCourses sorted by review score and then number of students (skip first 3, limit 5):");
                sortedCoursesAndReviewScoreSkipLimit.forEach(System.out::println);

                // Only get the element meet criteria
                List<Courses> sortedCoursesAndReviewScoreTakeWhile = courses.stream()
                                .sorted(compareByReviewScoreAndNoOfStudents)
                                .takeWhile(course -> course.getReviewScore() >= 95)
                                .toList();
                System.out.println("\nCourses sorted by review score and then number of students (take while >=95):");
                sortedCoursesAndReviewScoreTakeWhile.forEach(System.out::println);

                // droping the element
                List<Courses> sortedCoursesAndReviewScoreDropWhile = courses.stream()
                                .dropWhile(course -> course.getReviewScore() >= 95).toList();
                System.out.println("\nCourses sorted by review score and then number of students (drop while >=95):");
                sortedCoursesAndReviewScoreDropWhile.forEach(System.out::println);

                System.out.println("\nMax course (by review score and students): "
                                + courses.stream().max(compareByReviewScoreAndNoOfStudents));

                System.out.println("\nMin course (by review score and students): "
                                + courses.stream().min(compareByReviewScoreAndNoOfStudents)
                                                .orElse(new Courses("Java", "Language", 97, 8000)));

                System.out.println("\nMin course (with review score < 90): "
                                + courses.stream().filter(reviewScoreLessThan90).min(
                                                compareByNoOfStudents)
                                                .orElse(new Courses("Java 9", "Language", 99, 1000)));

                System.out.println("\nFirst course with review score < 90: "
                                + courses.stream().filter(reviewScoreLessThan90).findFirst());
                System.out.println("Any course with review score < 90: "
                                + courses.stream().filter(reviewScoreLessThan90).findAny());

                System.out.println("\nTotal students (courses with review score > 95): "
                                + courses.stream().filter(reviewScoreGreaterThan95).mapToInt(Courses::getNoOfStudents)
                                                .sum());
                System.out.println("Average students (courses with review score > 95): "
                                + courses.stream().filter(reviewScoreGreaterThan95).mapToInt(Courses::getNoOfStudents)
                                                .average());
                System.out.println("Max students (courses with review score > 95): "
                                + courses.stream().filter(reviewScoreGreaterThan95).mapToInt(Courses::getNoOfStudents)
                                                .max());
                System.out.println("Min students (courses with review score > 95): "
                                + courses.stream().filter(reviewScoreGreaterThan95).mapToInt(Courses::getNoOfStudents)
                                                .min());
                System.out.println("Count of courses with review score > 95: "
                                + courses.stream().filter(reviewScoreGreaterThan95).mapToInt(Courses::getNoOfStudents)
                                                .count());

                System.out.println("\nCourses grouped by category: \n"
                                + courses.stream().collect(Collectors.groupingBy(Courses::getCategory)));

                System.out.println("\nNumber of courses in each category: \n"
                                + courses.stream().collect(
                                                Collectors.groupingBy(Courses::getCategory, Collectors.counting())));

                System.out.println("\nHighest reviewed course in each category: \n"
                                + courses.stream()
                                                .collect(Collectors.groupingBy(Courses::getCategory,
                                                                Collectors.maxBy(Comparator.comparingInt(
                                                                                Courses::getReviewScore)))));

                System.out.println("\nCourse names mapped by category: \n"
                                + courses.stream().collect(
                                                Collectors.groupingBy(Courses::getCategory, Collectors
                                                                .mapping(Courses::getName, Collectors.toList()))));
        }
}
