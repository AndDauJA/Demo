package com.mtb.demo.integration.contextriderwear.config;

import com.mtb.demo.integration.common.config.CommonConfig;
import com.mtb.demo.integration.common.config.IntegrationPropertyConfig;
import com.mtb.demo.integration.common.domain.IntegrationApi;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ContextRiderWearConfig extends CommonConfig {

    private final IntegrationPropertyConfig integrationPropertyConfig;

    @Override
    public IntegrationApi getIntegrationPropertyDomain() {
        return integrationPropertyConfig.getBigcommerceApi();
    }
}
