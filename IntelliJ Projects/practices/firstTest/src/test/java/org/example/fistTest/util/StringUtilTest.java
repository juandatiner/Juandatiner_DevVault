package org.example.fistTest.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeatString_once () {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));

    }

    @Test
    public void repeatString_multipleTimes () {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));

    }

    @Test
    public void repeatString_zeroTimes () {
        Assert.assertEquals("", StringUtil.repeat("hola", 0));

    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatString_negativeTimes () {
        StringUtil.repeat("hola", -1);

    }

}
