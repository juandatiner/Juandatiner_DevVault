package com.platzi.isEmpty;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void is_not_empty() {

        assertFalse(StringUtil.isEmpty("hola"));
    }

    @Test
    public void is_empty() {

        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void is_empty_if_is_null() {

        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void is_empty_with_spaces() {

        assertTrue(StringUtil.isEmpty(" "));
    }
}
