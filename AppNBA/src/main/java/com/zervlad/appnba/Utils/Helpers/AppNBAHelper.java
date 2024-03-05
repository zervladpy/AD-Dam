package com.zervlad.appnba.Utils.Helpers;

public class AppNBAHelper {

    public static double parseHeight(String value) {
        double height = 0.0;
        try {
            value = value.replace("-", ".");

            height = Double.parseDouble(value);
        } catch (NullPointerException | NumberFormatException ignored) {
        }

        return height;
    }

    public static double parseWeight(String value) {
        double weight = 0.0;
        try {
            weight = Double.parseDouble(value);
            weight *= 0.45;
        } catch (NullPointerException | NumberFormatException ignored) {
        }
        return weight;
    }
    
}
