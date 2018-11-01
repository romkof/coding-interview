package com.interview.graph;

public class Utils {
    public static void isQuals(Object first, Object second) {
        if (!first.equals(second)) {
            throw new RuntimeException("it is not equals");
        }
    }

}
