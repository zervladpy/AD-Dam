package com.zervlad.appnba.Utils.Helpers;

public class AHelper {

    public static double convertHeight(String value) {
        value = value.replace("-", "");
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static double convertWeight(String value) {
        try {
            return Double.parseDouble(value) * 0.45;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
