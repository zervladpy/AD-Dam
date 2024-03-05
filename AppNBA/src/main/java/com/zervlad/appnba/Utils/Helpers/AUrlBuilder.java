package com.zervlad.appnba.Utils.Helpers;

import lombok.Getter;

@Getter
public class AUrlBuilder {

    private final String baseUrl;

    private String url;

    public AUrlBuilder(String baseUrl) {
        this.baseUrl = baseUrl;
        url = baseUrl + "?";
    }

    public AUrlBuilder addParameter(String parameter, String value) {
        if (!url.equals(baseUrl)) {
            url += "&";
        }
        url += parameter + "=" + value;
        return this;
    }

}
