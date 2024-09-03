package com.platzi.isEmpty;

public class StringUtil {

    public static boolean isEmpty(String str){

        return str == null || str.trim().isEmpty();  //.trim = delete de spaces on both sides
    }
}
