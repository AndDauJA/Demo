package com.mtb.demo.integration.common.config;

import com.mtb.demo.integration.common.domain.BigCommerceApi;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

@Profile("integration")
@Getter
@ConfigurationProperties("integration")
public final class IntegrationPropertyConfig {

    private final BigCommerceApi bigcommerceApi = new BigCommerceApi();
}
