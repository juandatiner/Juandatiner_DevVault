package com.platzi.functional._06_reference_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NamesUtils {

    public static void main(String[] args) {

        List<String> teachers = getList("Nicolas","Juan","Zulma");

        Consumer<String> printer = text -> System.out.println(text);
        teachers.forEach(printer);  //this method calls a consumer created named printer
        System.out.println("///////");
        //method reference operator in Java
        teachers.forEach(System.out::println); // this method calls a consumer established
    }

    public static <T> List<T> getList(T... elements){
        return Arrays.asList(elements);
    }
}
