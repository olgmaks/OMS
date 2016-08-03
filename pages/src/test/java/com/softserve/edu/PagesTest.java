package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;

public class PagesTest {

    @Test
    public void testClassPages() {
        Pages pages = new Pages();
        Assert.assertEquals(6,pages.avg(5,7),0.00001);
    }
}
