package com.synkers.quickblox.util;

public class Nonce {
    public static String generateNonce() {
        return String.valueOf((Math.random() * 9000) + 1000);
    }
}