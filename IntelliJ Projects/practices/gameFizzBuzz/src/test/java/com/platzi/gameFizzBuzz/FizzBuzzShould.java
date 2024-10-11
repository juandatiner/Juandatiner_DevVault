package com.platzi.gameFizzBuzz;

import static org.junit.Assert.*;
import org.junit.Test;

public class FizzBuzzShould {

    @Test
    public void if_number_is_divisible_by_3() {

        assertEquals("Fizz",FizzBuzz.fizzBuzz(9));
    }

    @Test
    public void if_number_is_divisible_by_5() {

        assertEquals("Buzz",FizzBuzz.fizzBuzz(50));
    }

    @Test
    public void if_number_is_divisible_by_3_and_5() {

        assertEquals("FizzBuzz",FizzBuzz.fizzBuzz(15));
    }

    @Test
    public void if_number_is_not_divisible_by_3_and_neither_by_5() {

        assertEquals( "1",FizzBuzz.fizzBuzz(1));
    }
}