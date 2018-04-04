package com.fsoares.util;

public class StringUtil {

    public static String packageToClass(String className) {
        int lastDotPosition = className.lastIndexOf(".") + 1;

        return className.substring(lastDotPosition);
    }
}
