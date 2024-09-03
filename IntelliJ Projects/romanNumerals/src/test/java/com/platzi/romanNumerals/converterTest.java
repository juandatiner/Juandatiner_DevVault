package com.platzi.romanNumerals;

import org.junit.Test;
import static org.junit.Assert.*;

public class converterTest {

    @Test
    public void if_number_is_1() {

        assertEquals("I", converter.arabicToRoman(1));
    }

    @Test
    public void if_number_is_2() {

        assertEquals("II", converter.arabicToRoman(2));
    }

    @Test
    public void if_number_is_3() {

        assertEquals("III", converter.arabicToRoman(3));
    }

    @Test
    public void if_number_is_5() {

        assertEquals("V", converter.arabicToRoman(5));
    }

    @Test
    public void if_number_is_6() {

        assertEquals("VI", converter.arabicToRoman(6));
    }

    @Test
    public void if_number_is_7() {

        assertEquals("VII", converter.arabicToRoman(7));
    }

    @Test
    public void if_number_is_8() {

        assertEquals("VIII", converter.arabicToRoman(8));
    }

    @Test
    public void if_number_is_10() {

        assertEquals("X", converter.arabicToRoman(10));
    }

    @Test
    public void if_number_is_11() {

        assertEquals("XI", converter.arabicToRoman(11));
    }

    @Test
    public void if_number_is_12() {

        assertEquals("XII", converter.arabicToRoman(12));
    }

    @Test
    public void if_number_is_13() {

        assertEquals("XIII", converter.arabicToRoman(13));
    }

    @Test
    public void if_number_is_15() {

        assertEquals("XV", converter.arabicToRoman(15));
    }

    @Test
    public void if_number_is_16() {

        assertEquals("XVI", converter.arabicToRoman(16));
    }

    @Test
    public void if_number_is_17() {

        assertEquals("XVII", converter.arabicToRoman(17));
    }

    @Test
    public void if_number_is_18() {

        assertEquals("XVIII", converter.arabicToRoman(18));
    }

    @Test
    public void if_number_is_20() {

        assertEquals("XX", converter.arabicToRoman(20));
    }

    @Test
    public void if_number_is_21() {

        assertEquals("XXI", converter.arabicToRoman(21));
    }

    @Test
    public void if_number_is_23() {

        assertEquals("XXIII", converter.arabicToRoman(23));
    }

    @Test
    public void if_number_is_25() {

        assertEquals("XXV", converter.arabicToRoman(25));
    }

    @Test
    public void if_number_is_28() {

        assertEquals("XXVIII", converter.arabicToRoman(28));
    }

    @Test
    public void if_number_is_32() {

        assertEquals("XXXII", converter.arabicToRoman(32));
    }

    @Test
    public void if_number_is_50() {

        assertEquals("L", converter.arabicToRoman(50));
    }

    @Test
    public void if_number_is_51() {

        assertEquals("LI", converter.arabicToRoman(51));
    }

    @Test
    public void if_number_is_55() {

        assertEquals("LV", converter.arabicToRoman(55));
    }

    @Test
    public void if_number_is_56() {

        assertEquals("LVI", converter.arabicToRoman(56));
    }

    @Test
    public void if_number_is_66() {

        assertEquals("LXVI", converter.arabicToRoman(66));
    }

    @Test
    public void if_number_is_70() {

        assertEquals("LXX", converter.arabicToRoman(70));
    }

    @Test
    public void if_number_is_80() {

        assertEquals("LXXX", converter.arabicToRoman(80));
    }

    @Test
    public void if_number_is_81() {

        assertEquals("LXXXI", converter.arabicToRoman(81));
    }

    @Test
    public void if_number_is_86() {

        assertEquals("LXXXVI", converter.arabicToRoman(86));
    }

    @Test
    public void if_number_is_88() {

        assertEquals("LXXXVIII", converter.arabicToRoman(88));
    }


    @Test
    public void if_number_is_100() {

        assertEquals("C", converter.arabicToRoman(100));
    }

    @Test
    public void if_number_is_126() {

        assertEquals("CXXVI", converter.arabicToRoman(126));
    }

    @Test
    public void if_number_is_388() {

        assertEquals("CCCLXXXVIII", converter.arabicToRoman(388));
    }

    @Test
    public void if_number_is_788() {

        assertEquals("DCCLXXXVIII", converter.arabicToRoman(788));
    }

    @Test
    public void if_number_is_1000() {

        assertEquals("M", converter.arabicToRoman(1000));
    }

    @Test
    public void if_number_is_2507() {

        assertEquals("MMDVII", converter.arabicToRoman(2507));
    }

    // with number that should subtract letters from the left

    @Test
    public void if_number_is_4() {

        assertEquals("IV", converter.arabicToRoman(4));
    }

    @Test
    public void if_number_is_9() {

        assertEquals("IX", converter.arabicToRoman(9));
    }

    @Test
    public void if_number_is_14() {

        assertEquals("XIV", converter.arabicToRoman(14));
    }

    @Test
    public void if_number_is_19() {

        assertEquals("XIX", converter.arabicToRoman(19));
    }

    @Test
    public void if_number_is_24() {

        assertEquals("XXIV", converter.arabicToRoman(24));
    }

    @Test
    public void if_number_is_40() {

        assertEquals("XL", converter.arabicToRoman(40));
    }

    @Test
    public void if_number_is_90() {

        assertEquals("XC", converter.arabicToRoman(90));
    }

    @Test
    public void if_number_is_99() {

        assertEquals("XCIX", converter.arabicToRoman(99));
    }

    @Test
    public void if_number_is_400() {

        assertEquals("CD", converter.arabicToRoman(400));
    }

    @Test
    public void if_number_is_990() {

        assertEquals("CMXC", converter.arabicToRoman(990));
    }

    @Test
    public void if_number_is_999() {

        assertEquals("CMXCIX", converter.arabicToRoman(999));
    }


}

