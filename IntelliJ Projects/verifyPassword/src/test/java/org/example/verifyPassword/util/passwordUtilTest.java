package org.example.verifyPassword.util;

import org.junit.Test;
import static org.example.verifyPassword.util.passwordUtil.SecurityLevel.*; //Se importa esto para que abajo solo se llame los niveles de seguridad
import static org.junit.Assert.*;

public class passwordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters(){

        assertEquals(WEAK,passwordUtil.assessPassword("12ab*"));
    }

    @Test
    public void weak_when_has_only_letters(){

        assertEquals(WEAK,passwordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){

        assertEquals(MEDIUM,passwordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols(){

        assertEquals(STRONG,passwordUtil.assessPassword("abcd1234!"));
    }
}