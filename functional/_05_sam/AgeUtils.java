package com.platzi.functional._05_sam;  //SAM SINGLE ABSTRACT METHOD = only one method

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeUtils {

    public static void main(String[] args) {

        // is an exception so that everything goes well
        Function<Integer, String> addCeros = x -> x < 10 ? "0" + x : String.valueOf(x);

        TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(year + "-" +
                        addCeros.apply(month) + "-" + addCeros.apply(day)); //Unit the date

        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(
                        parseDate.apply(day, month, year),LocalDate.now()
                ).getYears();  // calculate the time pasted between the date and the present date

        System.out.println(calculateAge.apply(10, 10, 1992));
    }

    @FunctionalInterface
    interface TriFunction<T, U, V, R>{ //Generic data, it's not known yet
        R apply(T t, U u, V v);

    }


}
