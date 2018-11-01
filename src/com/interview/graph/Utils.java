package com.interview.graph;

public class Utils {
    public static void assertEquals(Object actual, Object expected) {
        if (!actual.equals(expected)) {
            throw new RuntimeException(String.format("actual %s is not equals to expected %s",
                    actual.toString(),
                    expected.toString()));
        }
    }

}
