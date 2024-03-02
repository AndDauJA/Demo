package com.mtb.demo.integration.contextriderwear.service;

import com.mtb.demo.integration.common.config.IntegrationPropertyConfig;
import com.mtb.demo.integration.common.http.HttpHeaderEnricher;
import com.mtb.demo.integration.contextriderwear.api.ContextRiderWearApi;
import com.mtb.demo.integration.contextriderwear.client.ContextRiderWearClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Slf4j
@Service
public class ContextRiderWearService {

    private ContextRiderWearClient contextRiderWearClient;

    public ContextRiderWearService(
            IntegrationPropertyConfig integrationPropertyConfig,
            HttpHeaderEnricher httpHeaderEnricher) {
        integrationPropertyConfig.getBigcommerceApi().getClients().stream()
                .filter(client -> client.getClientClassApi() == ContextRiderWearApi.class)
                .findFirst()
                .ifPresent(client -> {
                    var webClient = WebClient.builder()
                            .baseUrl( client.getBaseUrl())
                            .defaultHeaders(httpHeaders -> httpHeaderEnricher.enrichOfXAuthToken(httpHeaders, client.getAccessToken()))
                            .build();
                    contextRiderWearClient = new ContextRiderWearClient(webClient);
                });
    }

    public Optional<ContextRiderWearClient> getContextRiderWearClient() {
        return Optional.ofNullable(contextRiderWearClient);
    }
}
