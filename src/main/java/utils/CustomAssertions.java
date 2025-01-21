package utils;

import org.testng.Assert;

public class CustomAssertions {

    public static void assertEquals(String actual, String expected, String errorMessage) {
        Assert.assertEquals(actual, expected, errorMessage);
    }
}
