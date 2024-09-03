package com.platzi.functional._04_functional;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class StringFuncions {

    public static void main(String[] args) {

        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text -> text + "!";

        System.out.println(quote.apply("Hi, I'm pregnant"));
        System.out.println(addMark.apply("Bye"));

        BiFunction<Integer, Integer, Integer> multiplication = //receives 2 data and gives new one, specific the type
                (x, y) -> x * y;

        System.out.println(multiplication.apply(5, 4));

        BinaryOperator<Integer> multiplication2 = //receives 2 data and gives new one, always is the same type
                (x, y) -> x * y;

        System.out.println(multiplication2.apply(5,3));

        BiFunction<String, Integer, String> leftPad =  // add n spaces to the right
                (text, number) -> String.format("%" + number + "s", text);

        System.out.println(leftPad.apply("Java", 10));

        List<BiFunction<String, Integer, String>> example = null; //is the form to save a lot of functions and apply all
    }

}
