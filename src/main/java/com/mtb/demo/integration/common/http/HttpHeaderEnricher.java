package com.mtb.demo.integration.common.http;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public final class HttpHeaderEnricher {

    private static final String HEADER_X_AUTH_TOKEN = "X-Auth-Token";

    public void enrichOfXAuthToken(final HttpHeaders httpHeaders, final String xAuthToken) {
        httpHeaders.add(HEADER_X_AUTH_TOKEN, xAuthToken);
    }
}
