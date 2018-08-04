package com.github.tmack8001.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.util.MultiValueMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetResponse {
    private MultiValueMap<String, String> args;
    private String data;
    private MultiValueMap<String, String> headers;
    private String method;
    private String origin;
    private String url;

    public GetResponse() {
    }

    public MultiValueMap<String, String> getArgs() {
        return args;
    }

    public GetResponse setArgs(MultiValueMap<String, String> args) {
        this.args = args;
        return this;
    }

    public String getData() {
        return data;
    }

    public GetResponse setData(String data) {
        this.data = data;
        return this;
    }

    public MultiValueMap<String, String> getHeaders() {
        return headers;
    }

    public GetResponse setHeaders(MultiValueMap<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public GetResponse setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getOrigin() {
        return origin;
    }

    public GetResponse setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public GetResponse setUrl(String url) {
        this.url = url;
        return this;
    }
}
