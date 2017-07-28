package com.epam.server;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class JUnitSimpleTest {
    private String message = "Robert";

    @Test
    public void testPrintMessage() {
        message = "Robert";
        assertEquals(message, this.message);
    }

    @Ignore
    @Test
    public void testSalutationMessage() {
        message = "Hi!" + "Robert";
        assertEquals(message, this.message);
    }

}
