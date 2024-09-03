package com.platzi.functional._11_composition;

import java.util.function.Function;

public class MathOperations {

    public static void main(String[] args) {
        Function<Integer, Integer> multiplyBy3 = x -> {
            System.out.println("Multiply x: " + x + " by 3");
            return x * 3;
        };

        Function<Integer, Integer> add1MultiplyBy3 =
                multiplyBy3.compose(y -> {  //compose execute the function and later the function that called it
                    System.out.println("I'm going to add 1 to: " + y);
                    return y + 1;
                });

        Function<Integer, Integer> andSquare =
                add1MultiplyBy3.andThen(x -> {
                    System.out.println("I'm elevating " + x + " to square");
                    return x * x;
                });

        System.out.println(
                add1MultiplyBy3.apply(5)
        );

        System.out.println(
                andSquare.apply(3)
        );
    }
}
