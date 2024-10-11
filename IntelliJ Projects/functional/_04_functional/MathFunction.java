package com.platzi.functional._04_functional;

import java.time.Period;
import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunction {

    public static void main(String[] args) {

        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {  //receive 1 int and return another int
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println(squareFunction.apply(5));
        System.out.println(squareFunction.apply(5));

        Function<Integer, Boolean> isOdd = x -> x % 2 == 1; //check if the number is odd and return a boolean

        Predicate<Integer> isEven = x -> x % 2 == 0; //check if sometime is true

        isEven.test(4); // return true because 4 is Even

        Predicate<Student> isApproved = student -> student.getGrade() >= 6.0;

        Student juanda = new Student(5.9); //new Student
        System.out.println(isApproved.test(juanda)); // false because >= 6.0
    }


    static class Student{

        private double grade;

        public Student(double grade) { //constructor
            this.grade = grade;
        }

        public double getGrade() {
            return grade;
        }
    }
}
