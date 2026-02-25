package com.training.demoApp.util;

public class CsvUtil {

    public static Double parseDouble(String value) {
        try {
            if (value == null || value.trim().isEmpty() || value.equalsIgnoreCase("NA")) {
                return null;
            }
            return Double.parseDouble(value.trim());
        } catch (Exception e) {
            return null; // avoid crashing for bad data
        }
    }

    public static Integer parseInteger(String value) {
        try {
            if (value == null || value.trim().isEmpty() || value.equalsIgnoreCase("NA")) {
                return null;
            }
            return Integer.parseInt(value.trim());
        } catch (Exception e) {
            return null;
        }
    }
}