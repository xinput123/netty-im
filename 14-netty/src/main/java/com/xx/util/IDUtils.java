package com.xx.util;

import java.util.UUID;

public class IDUtils {
    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
