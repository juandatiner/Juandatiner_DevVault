package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.NamesUtils;

import java.util.List;
import java.util.function.Function;

public class InferenceJ {

    public static void main(String[] args) {

        Function<Integer, String> converterFunction =
                integer -> "The double: " +(integer * 2);


        List<String> Students = NamesUtils.getList("Hugo", "Andres", "Danna");
        Students.forEach(System.out::println); //not is necessary specificity the type, because java knows for inference
    }
}
