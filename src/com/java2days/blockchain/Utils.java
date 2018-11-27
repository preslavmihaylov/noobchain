package com.java2days.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    public static boolean startsWithZeroes(String text, int zeroesCnt) {
        if (text.length() < zeroesCnt) {
            return false;
        }

        return text.substring(0, zeroesCnt).equals(repeatChar('0', zeroesCnt));
    }

    public static String calculateSHA256(String text) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            return bytesToHex(messageDigest.digest(text.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());

            return "error";
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte piece : hash) {
            String hex = Integer.toHexString(0xff & piece);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    private static String repeatChar(char ch, int cnt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt ; i++) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
