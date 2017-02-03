package com.synkers.quickblox.util;

public class Timestamp {
    public static String generateTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
}