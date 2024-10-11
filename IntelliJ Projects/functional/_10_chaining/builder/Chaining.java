package com.platzi.functional._10_chaining.builder;

public class Chaining {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hi")
                .append("studen")
                .append("of")
                .append("Platzi");

        Chainer chainer = new Chainer();

        //Chaining -> Encadenamiento
        chainer.sayHi().sayBye(); //is important to execute a lot of functions without save the result
    }

    static class Chainer {

        public Chainer sayHi(){
            System.out.println("Hi");
            return this;
        }

        public Chainer sayBye(){
            System.out.println("Bye");
            return this;
        }

    }
}
