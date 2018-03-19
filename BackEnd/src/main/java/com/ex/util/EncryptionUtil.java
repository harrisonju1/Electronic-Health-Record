package com.ex.util;

public class EncryptionUtil {
    public static String encrypt(String value) {
        String privatekey = "yXh3w5XOSEViRgHwfKnjPA8jJZ3RPEQE";
        String encrypted = "";
        int len = Math.max(value.length(), privatekey.length());
        for (int i = 0; i < len; i++) {
            char c = 0;
            if (i<value.length())
                c += value.charAt(i);
            if (i<privatekey.length())
                c += privatekey.charAt(i);
            encrypted += c;
        }
        return encrypted;
    }
    public static String decrypt(String value) {
        String privatekey = "yXh3w5XOSEViRgHwfKnjPA8jJZ3RPEQE";
        String decrypted = "";
        int len = value.length();
        for (int i = 0; i < len; i++) {
            char c = value.charAt(i);
            if (i<privatekey.length())
                c -= privatekey.charAt(i);
            decrypted += c;
        }
        decrypted = decrypted.trim();
        return decrypted;
    }
}
