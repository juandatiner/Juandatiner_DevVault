package com.platzi.functional._15_streams_intro;

import com.platzi.functional._06_reference_operator.NamesUtils;

import java.util.List;
import java.util.stream.Stream;

public class StreamsJ {

    public static void main(String[] args) {

        List<String> courseList = NamesUtils.getList(
                "Java",
                "Fronted",
                "Backed",
                "FullStack");

        for (String course: courseList){
            String newCourseName = course.toLowerCase().replace("!" , "!!");
            System.out.println("Platzi: " + newCourseName); // add a prefix
        }

        Stream<String> coursesStream = Stream.of("Java",
                "Fronted",
                "Backed",
                "FullStack");

//        Stream<Integer> courseLengthStream = coursesStream.map(course -> course.length()); // new Stream of a Stream
//
//        Optional<Integer> longest = courseLengthStream.max((x, y) -> y-x); // get the max of the course


        // A Stream only can be used one time, after is invalid
        Stream<String> emphasisCourses = coursesStream.map(course -> course + "!"); //new Stream with all the items with !"
        Stream<String> justJavaCourses = emphasisCourses.filter(course -> course.contains("Java")); // new Stream with just the word "Java"
        justJavaCourses.forEach(System.out::println);

        Stream<String> courseStream2 = courseList.stream(); // list to a stream

        addOperator(
                courseStream2.map(course -> course + "!!") // is more fluent
                .filter(course -> course.contains("Java"))
        ).forEach(System.out::println);

        //Types Operation
        //  Final Operation = no give more (void). example forEach
        //  Intermediate Operation = give some. example filter

    }

    static <T> Stream<T> addOperator(Stream<T> stream){
        return stream.peek(data -> System.out.println("Dato: " + data));//get and give the same without modify
    }
}
