package com.mea.happyclients.infrastructure;

/**
 * A Utils class.
 */
public class Utils {

    public static String encodePassword(String password) {

        int hash = 7;
        for (int i = 0; i < password.length(); i++) {
            hash = hash*31 + password.charAt(i);
        }

        return Integer.toString(hash);
    }

}
