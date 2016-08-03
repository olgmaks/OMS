package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;

public class ToolsTest {

    @Test
    public void testClassTools() {
        Tools tools = new Tools();
        Assert.assertEquals(12,tools.add(5,7),0.00001);
    }
}
