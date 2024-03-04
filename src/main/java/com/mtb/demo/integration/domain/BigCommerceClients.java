package com.mtb.demo.integration.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BigCommerceClients {

    private String clientClassApi;
    private String baseUrl;
    private String accessToken;

    public Class<?> getClientClassApi() {
        try {
            return Class.forName(clientClassApi);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Wrong class name in application-integration.property name clientClassApi", e);
        }
    }
}
