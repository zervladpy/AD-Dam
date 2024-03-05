package com.zervlad.appnba.Utils.Builder;

import lombok.Getter;

@Getter
public class UrlBuilder {

    private String baseUrl;
    private String url;

    private UrlBuilder() {
    }
    
    public static UrlBuilder builder() {
        return new UrlBuilder();
    }

    public UrlBuilder setUrl(String url) {
        this.baseUrl = url;
        this.url = url;

        return this;
    }

    public UrlBuilder setParameter(String key, String value) {
        if (url.equals(baseUrl)) {
            url += "?";
        } else {
            url += "&";
        }

        url += key + "=" + value;

        return this;
    }

}
