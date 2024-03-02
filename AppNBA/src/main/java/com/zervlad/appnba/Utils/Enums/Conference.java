package com.zervlad.appnba.Utils.Enums;

public enum Conference {
    EAST("East"), WEST("West"), UNKNOWN("");

    private String value;

    private Conference(String value) {
        this.value = value;
    }

    public static Conference fromString(String value) {
        for (Conference conference : Conference.values()) {
            if (conference.value.equals(value)) {
                return conference;
            }
        }
        return UNKNOWN;
    }
}
