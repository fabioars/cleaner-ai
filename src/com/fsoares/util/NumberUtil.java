package com.fsoares.util;

public class NumberUtil {

    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

}
