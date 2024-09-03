package com.platzi.functional._15_streams_intro;

import java.util.stream.IntStream;

public class TypeStreams {

    public static void main(String[] args) {

        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1); // iterate infinite
        infiniteStream.limit(1000) // limit 1000 numbers
                .parallel() // distribute the job to all the processor cores ->
                // This return the data disorganized but is better to a lot of data
                .filter(x -> x % 2 == 0) // even numbers
                .forEach(System.out::println);
    }
}
