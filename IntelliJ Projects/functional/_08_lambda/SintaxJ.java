package com.platzi.functional._08_lambda;

import com.platzi.functional._06_reference_operator.NamesUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class SintaxJ {

    public static void main(String[] args) {

        List<String> curses = NamesUtils.getList("Java", "Functional");

        curses.forEach(curse -> System.out.println(curse));

        useZero(() -> 2); //lambda that not receive none argument and give a value return

        usePredicate(text -> text.isEmpty()); //lambda without receive any

        useBiFunction((x,y) -> x * y); //lambda represents the BiFunction and give the value

        useBiFunction((Integer x, Integer y) -> x * y); // is the same lambda but specifying the type object -> Legibility

        useBiFunction((x, y) -> { // if you have a lambda more specific with more arguments, you must to specific the return
            System.out.println("X: " + x + "Y: " + y);
            return x - y;
        });

        useNothing(() -> {}); //lambda not receive none data and not give none data
    }

    static void useZero(ZeroArguments zeroArguments) {

    }

    static void usePredicate(Predicate<String> predicate){

    }

    static void useBiFunction(BiFunction<Integer, Integer, Integer> operation) {

    }

    static void useNothing(Nothing nothing){

    }

    @FunctionalInterface
    interface ZeroArguments {

        int get();
    }

    @FunctionalInterface
    interface Nothing { // does nothing

        void nothing();
    }
}
