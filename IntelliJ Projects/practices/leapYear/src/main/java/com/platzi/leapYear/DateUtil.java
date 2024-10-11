package com.platzi.leapYear;

public class DateUtil {

    public static boolean isLeapYear(int year) {

        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;

        //another form to white de code could be:
        // if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) return true;
        // else return false;
    }
}
