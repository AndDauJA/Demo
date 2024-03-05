package com.mtb.demo.integration.contextriderwear.client;

import com.mtb.demo.integration.contextriderwear.api.ContextRiderWearApi;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Getter
public class ContextRiderWearClient {

    private final ContextRiderWearApi api;

    public ContextRiderWearClient(WebClient webClient) {
        final HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();

        api = httpServiceProxyFactory.createClient(ContextRiderWearApi.class);
    }
}
