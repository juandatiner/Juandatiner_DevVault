package org.example.fistTest.util;

public class StringUtil {

    public static String repeat(String str, int times){

        if (times < 0){
            throw new IllegalArgumentException("negative times not allowed");
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return result.toString();
    }
}
