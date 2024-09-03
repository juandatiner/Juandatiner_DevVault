package com.platzi.romanNumerals;

public class converter {

    public static String arabicToRoman(int number){

        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                result.append(romanNumerals[i]);
                number -= values[i];
            }
        }

        return result.toString();
    }
}


//        String result = "";
//        int i = 0;
//        int rest = number;
//
//        while(rest != 0) {
//            if (rest >= 1000 ){
//                result += "M";
//                rest -= 1000;
//
//            } else if (rest >= 500 && rest < 1000){
//                result += "D";
//                rest -= 500;
//
//            } else if (rest >= 100 && rest < 400){
//                result += "C";
//                rest -= 100;
//
//            } else if (rest >= 50 && rest < 100){
//                result += "L";
//                rest -= 50;
//
//            } else if (rest >= 10 && rest < 40){
//                result += "X";
//                rest -= 10;
//
//            } else if (rest >= 5 && rest < 10) {
//                result += "V";
//                rest -= 5;
//
//            } else if (rest <= 3){
//                result += "I";
//                rest -= 1;
//
//            }
//        }return result;